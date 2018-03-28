private void checkCargoes(LogBuilder lb) {
    final Unit carrier = getUnit();
    if (carrier.isAtSea())
        return;
    final AIUnit aiCarrier = getAIUnit();
    List<Unit> unitsPresent = carrier.getUnitList();
    List<Goods> goodsPresent = carrier.getCompactGoods();
    List<TransportableAIObject> todo = new ArrayList<>();
    List<TransportableAIObject> drop = new ArrayList<>();
    String reason;
    PathNode path;
    boolean dump;
    lb.add(" [check");
    for (Cargo cargo : tCopy()) {
        dump = false;
        TransportableAIObject t = cargo.getTransportable();
        reason = invalidReason(aiCarrier, cargo.getCarrierTarget());
        if (reason != null || (reason = cargo.check(aiCarrier)) != null) {
            removeCargo(cargo);
            lb.add(", INVALID(", reason, ") ", cargo.toShortString());
        } else if (cargo.isDelivered()) {
            removeCargo(cargo);
            lb.add(", COMPLETED ", cargo.toShortString());
        } else if (!cargo.hasPath() && !cargo.retry()) {
            reason = " no-path";
            dump = true;
        } else if (carrier.hasTile() && (reason = cargo.update()) != null) {
            if (reason.startsWith("invalid")) {
                removeCargo(cargo);
                lb.add(", FAIL(", reason, ") ", cargo.toShortString());
            } else if (cargo.retry()) {
                lb.add(", retry-", cargo.getTries(), "(", reason, ")");
            } else {
                dump = true;
            }
        } else if (cargo.isCollectable()) {
            lb.add(", collect ", cargo.toShortString());
        } else if (cargo.isDeliverable()) {
            lb.add(", deliver ", cargo.toShortString());
        } else {
            lb.add(", ok ", cargo.toShortString());
            cargo.resetTries();
        }
        if (dump) {
            if (cargo.isCarried()) {
                dumpCargo(cargo, lb);
            } else {
                removeCargo(cargo);
                lb.add(", dropped(", reason, ") ", cargo.toShortString());
            }
        }
        if (t instanceof AIUnit) {
            unitsPresent.remove(((AIUnit) t).getUnit());
        } else if (t instanceof AIGoods) {
            Goods goods = ((AIGoods) t).getGoods();
            if (goods != null) {
                removeInPlace(goodsPresent, AbstractGoods.matches(goods.getType()));
            }
        }
    }
    if (!unitsPresent.isEmpty()) {
        lb.add(", found unexpected units");
        for (Unit u : unitsPresent) {
            AIUnit aiu = getAIMain().getAIUnit(u);
            if (aiu == null)
                throw new IllegalStateException("Bogus:" + u);
            todo.add(aiu);
        }
    }
    if (!goodsPresent.isEmpty()) {
        lb.add(", found unexpected goods");
        for (Goods g : goodsPresent) {
            AIGoods aig = new AIGoods(getAIMain(), carrier, g.getType(), g.getAmount(), null);
            todo.add(aig);
        }
    }
    while (!todo.isEmpty()) {
        TransportableAIObject t = todo.remove(0);
        if (!queueTransportable(t, false, lb))
            drop.add(t);
    }
    if (!drop.isEmpty()) {
        path = carrier.getTrivialPath();
        Location end = (path == null) ? null : path.getLastNode().getLocation();
        while (!drop.isEmpty()) {
            TransportableAIObject t = drop.remove(0);
            if (t.leaveTransport()) {
                lb.add(" ", t, " left");
            } else if (end != null) {
                try {
                    Cargo cargo = Cargo.newCargo(t, carrier, end, false);
                    boolean result = queueCargo(cargo, false, lb);
                    lb.add(" to drop at ", Location.upLoc(end), "=", result);
                } catch (FreeColException fce) {
                    lb.add(" ", t, " drop-fail(", fce.getMessage(), ")");
                }
            } else {
                lb.add(" ", t, " stuck");
            }
        }
    }
    lb.add("]");
}