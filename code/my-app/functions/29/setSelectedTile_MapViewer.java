boolean setSelectedTile(Tile newTile) {
    Tile oldTile = this.selectedTile;
    boolean ret = false;
    selectedTile = newTile;
    if (viewMode == GUI.MOVE_UNITS_MODE) {
        if (activeUnit == null || activeUnit.getTile() != newTile) {
            Unit unitInFront = findUnitInFront(newTile);
            if (unitInFront != null) {
                ret = gui.setActiveUnit(unitInFront);
                updateCurrentPathForActiveUnit();
            } else {
                gui.setFocus(newTile);
                ret = true;
            }
        }
    }
    if (!onScreen(newTile) || getClientOptions().getBoolean(ClientOptions.ALWAYS_CENTER)) {
        gui.setFocus(newTile);
        ret = true;
    } else {
        if (oldTile != null) {
            gui.refreshTile(oldTile);
        }
        if (newTile != null) {
            gui.refreshTile(newTile);
        }
    }
    return ret;
}