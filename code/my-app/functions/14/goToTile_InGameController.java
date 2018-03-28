public boolean goToTile(Unit unit, Tile tile) {
    if (!requireOurTurn() || unit == null || !getMyPlayer().owns(unit))
        return false;
    if (!getGUI().confirmClearTradeRoute(unit))
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askSetDestination(unit, tile);
    if (ret) {
        moveToDestination(unit, null);
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}