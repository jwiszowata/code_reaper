public boolean disbandUnit(Unit unit) {
    if (!requireOurTurn() || unit == null)
        return false;
    if (unit.getColony() != null && !getGUI().confirmLeaveColony(unit))
        return false;
    final Tile tile = (getGUI().isShowingSubPanel()) ? null : unit.getTile();
    if (!getGUI().confirm(tile, StringTemplate.key("disbandUnit.text"), unit, "disbandUnit.yes", "cancel"))
        return false;
    boolean ret = askServer().disbandUnit(unit) && unit.isDisposed();
    if (ret) {
        updateGUI(tile);
    }
    return ret;
}