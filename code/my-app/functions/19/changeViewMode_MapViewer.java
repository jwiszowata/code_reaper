void changeViewMode(int newViewMode) {
    if (newViewMode != viewMode) {
        logger.fine("Changed to " + ((newViewMode == GUI.MOVE_UNITS_MODE) ? "Move Units" : "View Terrain") + " mode");
        viewMode = newViewMode;
        if (viewMode == GUI.MOVE_UNITS_MODE)
            restartBlinking();
        else
            stopBlinking();
        if (activeUnit != null) {
            Tile tile = activeUnit.getTile();
            if (isTileVisible(tile))
                gui.refreshTile(tile);
            if (selectedTile != tile && isTileVisible(selectedTile))
                gui.refreshTile(selectedTile);
        } else if (isTileVisible(selectedTile))
            gui.refreshTile(selectedTile);
        gui.updateMapControls();
    }
}