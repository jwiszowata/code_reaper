private boolean tRemove(Cargo cargo) {
    boolean result = false, change = false;
    final TransportableAIObject t = cargo.getTransportable();
    synchronized (cargoes) {
        for (int i = 0; i < cargoes.size(); i++) {
            if (cargoes.get(i).getTransportable() == t) {
                cargoes.remove(i);
                tSpace();
                change = i == 0;
                result = true;
                break;
            }
        }
    }
    if (change)
        tRetarget();
    return result;
}