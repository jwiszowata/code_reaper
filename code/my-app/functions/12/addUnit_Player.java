public final boolean addUnit(final Unit newUnit) {
    if (newUnit == null)
        return false;
    if (!this.owns(newUnit)) {
        throw new IllegalStateException("Adding another players unit:" + newUnit.getId() + " to " + this);
    }
    if (hasUnit(newUnit))
        return false;
    synchronized (this.units) {
        return this.units.add(newUnit);
    }
}