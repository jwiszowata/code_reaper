private void tRetarget() {
    Cargo c;
    synchronized (cargoes) {
        c = find(cargoes, Cargo::isValid);
    }
    setTarget(Location.upLoc((c == null) ? getAIUnit().getTrivialTarget() : c.getCarrierTarget()));
}