public void setStateToAllChildren(UnitState state) {
    if (canCarryUnits()) {
        for (Unit u : getUnitList()) u.setState(state);
    }
}