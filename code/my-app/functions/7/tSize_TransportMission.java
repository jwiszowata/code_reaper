private int tSize() {
    int size;
    synchronized (cargoes) {
        size = cargoes.size();
    }
    return size;
}