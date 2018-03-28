public List<Unit> getOwnedUnitList() {
    synchronized (this.ownedUnits) {
        return new ArrayList<>(this.ownedUnits);
    }
}