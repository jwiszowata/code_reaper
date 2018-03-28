public boolean add(final Locatable locatable) {
    NoAddReason reason = getNoAddReason(locatable);
    switch(reason) {
        case NONE:
            break;
        case ALREADY_PRESENT:
            return true;
        default:
            throw new IllegalStateException("Can not add " + locatable + " to " + this + " because " + reason);
    }
    Unit unit = (Unit) locatable;
    if (!super.add(unit))
        return false;
    unit.setState(Unit.UnitState.IN_COLONY);
    unit.setMovesLeft(0);
    setWorkFor(unit);
    getColony().invalidateCache();
    return true;
}