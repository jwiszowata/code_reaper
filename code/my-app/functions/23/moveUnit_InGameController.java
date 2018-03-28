public boolean moveUnit(Unit unit, Direction direction) {
    if (!requireOurTurn() || unit == null || direction == null || !unit.hasTile())
        return false;
    if (!askClearGotoOrders(unit))
        return false;
    final Tile oldTile = unit.getTile();
    UnitWas unitWas = new UnitWas(unit);
    ColonyWas colonyWas = (unit.getColony() == null) ? null : new ColonyWas(unit.getColony());
    changeState(unit, UnitState.ACTIVE);
    moveDirection(unit, direction, true);
    boolean ret = unit.getTile() != oldTile || unitWas.fireChanges();
    if (ret) {
        if (colonyWas != null)
            colonyWas.fireChanges();
        updateGUI(null);
        if (!unit.couldMove() && unit.hasTile()) {
            Colony colony = unit.getTile().getColony();
            if (colony != null)
                colonyPanel(colony, unit);
        }
    }
    return ret;
}