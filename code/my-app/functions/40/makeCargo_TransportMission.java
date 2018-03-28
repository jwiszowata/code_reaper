public Cargo makeCargo(TransportableAIObject t, LogBuilder lb) {
    final Unit carrier = getUnit();
    String reason;
    Cargo cargo = null;
    if (t.getTransportDestination() == null) {
        if (!isCarrying(t)) {
            reason = "null transport destination";
        } else {
            PathNode path = carrier.getTrivialPath();
            if (path == null) {
                reason = "null transport destination";
            } else {
                try {
                    reason = null;
                    cargo = Cargo.newCargo(t, carrier, path.getLastNode().getLocation(), true);
                } catch (FreeColException fce) {
                    reason = fce.getMessage();
                    cargo = null;
                }
            }
        }
    } else if (!isCarrying(t) && !t.carriableBy(carrier)) {
        reason = "carrier " + carrier.toShortString() + " can not carry";
    } else {
        try {
            reason = null;
            cargo = Cargo.newCargo(t, carrier);
        } catch (FreeColException fce) {
            reason = fce.getMessage();
            cargo = null;
        }
    }
    if (reason == null) {
        lb.add(", made ", cargo.toShortString());
        return cargo;
    } else {
        lb.add(", failed to make cargo for ", t, " (", reason, ")");
        return null;
    }
}