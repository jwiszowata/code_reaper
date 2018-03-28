public void reconnect(Unit active, Tile tile) {
    setupMouseListeners();
    setActiveUnit(null);
    requestFocusInWindow();
    initializeInGame();
    closeMenus();
    clearGotoPath();
    resetMenuBar();
    resetMapZoom();
    changeViewMode(GUI.VIEW_TERRAIN_MODE);
    setSelectedTile(tile);
    setFocus(tile);
    if (active != null) {
        changeViewMode(GUI.MOVE_UNITS_MODE);
        setActiveUnit(active);
        centerActiveUnit();
    }
}