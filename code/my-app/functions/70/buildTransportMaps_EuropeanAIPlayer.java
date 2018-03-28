private void buildTransportMaps(LogBuilder lb) {
    transportDemand.clear();
    transportSupply.clear();
    wagonsNeeded.clear();
    nNavalCarrier = 0;
    for (AIColony aic : getAIColonies()) {
        Colony colony = aic.getColony();
        if (colony.isConnectedPort())
            changeNeedWagon(colony.getTile(), 0);
    }
    for (AIUnit aiu : getAIUnits()) {
        if (aiu.hasMission() && !aiu.getMission().isValid())
            continue;
        Unit u = aiu.getUnit();
        if (u.isCarrier()) {
            if (u.isNaval()) {
                nNavalCarrier--;
            } else {
                changeNeedWagon(u.getTile(), -1);
            }
        } else {
            checkTransport(aiu);
            if (requestsTransport(aiu)) {
                transportSupply.add(aiu);
                aiu.incrementTransportPriority();
                nNavalCarrier++;
            }
        }
    }
    for (AIColony aic : getAIColonies()) {
        for (AIGoods aig : aic.getExportGoods()) {
            checkTransport(aig);
            if (requestsTransport(aig)) {
                transportSupply.add(aig);
                aig.incrementTransportPriority();
                Location src = aig.getTransportSource();
                Location dst = aig.getTransportDestination();
                if (!Map.isSameContiguity(src, dst)) {
                    nNavalCarrier++;
                }
            }
        }
        Colony colony = aic.getColony();
        if (!colony.isConnectedPort()) {
            changeNeedWagon(colony.getTile(), 1);
        }
    }
    for (Wish w : getWishes()) {
        TransportableAIObject t = w.getTransportable();
        if (t != null && t.getTransport() == null && t.getTransportDestination() != null) {
            Location loc = Location.upLoc(t.getTransportDestination());
            appendToMapList(transportDemand, loc, w);
        }
    }
    if (!transportSupply.isEmpty()) {
        lb.add("\n  Transport Supply:");
        for (TransportableAIObject t : transportSupply) {
            lb.add(" ", t.getTransportPriority(), "+", t);
        }
    }
    if (!transportDemand.isEmpty()) {
        lb.add("\n  Transport Demand:");
        forEachMapEntry(transportDemand, e -> {
            Location ld = e.getKey();
            lb.add("\n    ", ld, "[");
            for (Wish w : e.getValue()) lb.add(" ", w);
            lb.add(" ]");
        });
    }
}