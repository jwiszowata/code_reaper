private List<Cargo> tSet(List<Cargo> nxt, boolean setSpace) {
    List<Cargo> old = tCopy();
    synchronized (cargoes) {
        cargoes.clear();
        cargoes.addAll(transform(nxt, Cargo::isValid));
        if (setSpace)
            tSpace();
    }
    tRetarget();
    return old;
}