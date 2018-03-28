private void clearOwnedUnits() {
    synchronized (this.ownedUnits) {
        this.ownedUnits.clear();
    }
}