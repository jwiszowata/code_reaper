public int getUnitCount() {
    synchronized (this.units) {
        return count(this.units);
    }
}