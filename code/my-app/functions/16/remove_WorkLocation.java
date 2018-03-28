public boolean remove(final Locatable locatable) {
    if (!(locatable instanceof Unit)) {
        throw new IllegalStateException("Not a unit: " + locatable);
    }
    Unit unit = (Unit) locatable;
    if (!contains(unit))
        return true;
    if (!super.remove(unit))
        return false;
    unit.setState(Unit.UnitState.ACTIVE);
    unit.setMovesLeft(0);
    if (isEmpty())
        updateProductionType();
    getColony().invalidateCache();
    return true;
}