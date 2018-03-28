public boolean queueTransportable(TransportableAIObject t, boolean requireMatch, LogBuilder lb) {
    Cargo cargo = makeCargo(t, lb);
    return (cargo == null) ? false : queueCargo(cargo, requireMatch, lb);
}