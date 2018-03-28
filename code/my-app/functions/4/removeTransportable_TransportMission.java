public boolean removeTransportable(TransportableAIObject t) {
    Cargo cargo = tFind(t);
    return (cargo == null) ? false : tRemove(cargo);
}