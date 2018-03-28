public boolean putOutsideColony(Unit unit) {
    Colony colony;
    if (!requireOurTurn() || unit == null || (colony = unit.getColony()) == null)
        return false;
    if (!getGUI().confirmLeaveColony(unit))
        return false;
    ColonyWas colonyWas = new ColonyWas(colony);
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askServer().putOutsideColony(unit) && unit.getLocation() == colony.getTile();
    if (ret) {
        colonyWas.fireChanges();
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}