public Location getTransportTarget(TransportableAIObject t) {
    if (isCarrying(t))
        return null;
    Cargo cargo = tFind(t);
    return (cargo == null) ? null : cargo.getTransportTarget();
}