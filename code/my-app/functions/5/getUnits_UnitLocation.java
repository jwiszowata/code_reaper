public Stream<Unit> getUnits() {
    synchronized (this.units) {
        return getUnitList().stream();
    }
}