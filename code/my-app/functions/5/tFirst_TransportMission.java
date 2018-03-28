private Cargo tFirst() {
    synchronized (cargoes) {
        return find(cargoes, Cargo::isValid);
    }
}