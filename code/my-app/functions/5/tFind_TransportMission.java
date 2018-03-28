private Cargo tFind(TransportableAIObject t) {
    synchronized (cargoes) {
        return find(cargoes, c -> c.getTransportable() == t);
    }
}