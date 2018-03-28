private List<Cargo> tClear() {
    List<Cargo> old = new ArrayList<>();
    synchronized (cargoes) {
        old.addAll(cargoes);
        cargoes.clear();
    }
    return old;
}