public Unit getUnitByName(String name) {
    synchronized (this.units) {
        return find(this.units, matchKeyEquals(name, Unit::getName));
    }
}