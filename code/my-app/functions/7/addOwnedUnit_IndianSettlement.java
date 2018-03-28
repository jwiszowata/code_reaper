public void addOwnedUnit(Unit unit) {
    synchronized (this.ownedUnits) {
        if (!this.ownedUnits.contains(unit)) {
            this.ownedUnits.add(unit);
        }
    }
}