private boolean tAdd(Cargo cargo, int index) {
    if (!cargo.isValid())
        return false;
    if (tFind(cargo.getTransportable()) != null)
        return true;
    boolean change = false;
    synchronized (cargoes) {
        change = cargoes.isEmpty() || index == 0;
        if (index >= 0) {
            cargoes.add(index, cargo);
        } else {
            cargoes.add(cargo);
        }
        tSpace();
    }
    if (change)
        tRetarget();
    return true;
}