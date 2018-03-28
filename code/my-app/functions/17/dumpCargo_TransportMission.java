public boolean dumpCargo(Cargo cargo, LogBuilder lb) {
    TransportableAIObject t = cargo.getTransportable();
    if (isCarrying(t))
        t.leaveTransport();
    if (!isCarrying(t) && tFind(t) != null)
        removeCargo(cargo);
    if (tFind(t) != null) {
        String reason = cargo.dump();
        if (reason != null) {
            lb.add(", dump failed(", reason, ")");
            return false;
        } else {
            lb.add(", dumping");
        }
    }
    return true;
}