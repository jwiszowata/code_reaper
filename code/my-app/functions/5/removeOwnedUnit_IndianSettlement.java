public boolean removeOwnedUnit(Unit unit) {
    synchronized (this.ownedUnits) {
        return this.ownedUnits.remove(unit);
    }
}