public boolean dumpTransportable(TransportableAIObject t, LogBuilder lb) {
    if (t == null)
        return true;
    Cargo cargo = tFind(t);
    if (cargo == null)
        return true;
    if (!isCarrying(t)) {
        removeTransportable(t);
        return true;
    }
    return dumpCargo(cargo, lb);
}