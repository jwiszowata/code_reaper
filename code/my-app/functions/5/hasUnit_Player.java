public boolean hasUnit(Unit unit) {
    synchronized (this.units) {
        return this.units.contains(unit);
    }
}