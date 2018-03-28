boolean setActiveUnit(Unit activeUnit) {
    Tile tile = (activeUnit == null) ? null : activeUnit.getTile();
    this.activeUnit = activeUnit;
    if (viewMode == GUI.VIEW_TERRAIN_MODE && activeUnit != null) {
        changeViewMode(GUI.MOVE_UNITS_MODE);
    }
    if (activeUnit == null || tile == null) {
        gui.getCanvas().stopGoto();
    } else {
        updateCurrentPathForActiveUnit();
        if (!gui.setSelectedTile(tile) || getClientOptions().getBoolean(ClientOptions.JUMP_TO_ACTIVE_UNIT)) {
            gui.setFocus(tile);
            return true;
        }
    }
    return false;
}