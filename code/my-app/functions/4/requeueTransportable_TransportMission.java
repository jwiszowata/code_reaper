public boolean requeueTransportable(TransportableAIObject t, LogBuilder lb) {
    Cargo cargo = tFind(t);
    return (cargo == null) ? queueTransportable(t, false, lb) : requeueCargo(cargo, lb);
}