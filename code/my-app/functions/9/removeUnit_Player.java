public boolean removeUnit(final Unit oldUnit) {
    if (oldUnit == null)
        return false;
    nextActiveUnitIterator.remove(oldUnit);
    nextGoingToUnitIterator.remove(oldUnit);
    synchronized (this.units) {
        return this.units.remove(oldUnit);
    }
}