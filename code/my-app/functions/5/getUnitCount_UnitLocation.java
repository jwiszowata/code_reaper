public int getUnitCount() {
    synchronized (this.units) {
        return this.units.size();
    }
}