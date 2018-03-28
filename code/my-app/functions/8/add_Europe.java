public boolean add(Locatable locatable) {
    boolean result = super.add(locatable);
    if (result && locatable instanceof Unit) {
        Unit unit = (Unit) locatable;
        unit.setState((unit.canCarryUnits()) ? UnitState.ACTIVE : UnitState.SENTRY);
    }
    return result;
}