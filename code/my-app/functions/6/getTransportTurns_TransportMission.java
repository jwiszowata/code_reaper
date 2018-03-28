public int getTransportTurns(TransportableAIObject t) {
    if (isCarrying(t))
        return INFINITY;
    Cargo cargo = tFind(t);
    return (cargo == null) ? INFINITY : cargo.getTurns();
}