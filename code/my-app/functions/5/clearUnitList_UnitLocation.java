protected void clearUnitList() {
    synchronized (this.units) {
        this.units.clear();
    }
}