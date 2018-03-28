public boolean selectDestination(Unit unit) {
    if (!requireOurTurn() || unit == null)
        return false;
    if (!getGUI().confirmClearTradeRoute(unit))
        return false;
    Location destination = getGUI().showSelectDestinationDialog(unit);
    if (destination == null)
        return false;
    UnitWas unitWas = new UnitWas(unit);
    boolean ret = askSetDestination(unit, destination);
    if (ret) {
        if (destination instanceof Europe) {
            if (unit.hasTile() && unit.getTile().isDirectlyHighSeasConnected()) {
                moveTo(unit, destination);
            } else {
                moveToDestination(unit, null);
            }
        } else {
            if (unit.isInEurope()) {
                moveTo(unit, destination);
            } else {
                moveToDestination(unit, null);
            }
        }
        unitWas.fireChanges();
        updateGUI(null);
    }
    return ret;
}