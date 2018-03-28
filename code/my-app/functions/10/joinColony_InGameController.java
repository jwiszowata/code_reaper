public boolean joinColony(Unit unit) {
    final Tile tile = unit.getTile();
    final Colony colony = (tile == null) ? null : tile.getColony();
    boolean ret = colony != null && askServer().joinColony(unit, colony) && unit.getState() == UnitState.IN_COLONY;
    if (ret) {
        updateGUI(null);
        colonyPanel(colony, unit);
    }
    return ret;
}