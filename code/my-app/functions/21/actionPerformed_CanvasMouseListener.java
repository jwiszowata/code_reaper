public void actionPerformed(ActionEvent ae) {
    doubleClickTimer.stop();
    Tile tile = canvas.convertToMapTile(centerX, centerY);
    if (tile == null)
        return;
    switch(canvas.getViewMode()) {
        case GUI.MOVE_UNITS_MODE:
            Unit unit = canvas.getActiveUnit();
            if (unit != null && unit.getTile() == tile) {
                igc().clearGotoOrders(unit);
                canvas.updateCurrentPathForActiveUnit();
            } else {
                immediateSettlement(tile);
            }
            break;
        case GUI.VIEW_TERRAIN_MODE:
        default:
            break;
    }
    getGUI().setSelectedTile(tile);
}