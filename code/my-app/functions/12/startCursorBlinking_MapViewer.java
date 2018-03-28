void startCursorBlinking() {
    cursor = new TerrainCursor();
    cursor.addActionListener((ActionEvent ae) -> {
        Unit unit = activeUnit;
        if (unit != null) {
            Tile tile = unit.getTile();
            if (isTileVisible(tile))
                gui.refreshTile(tile);
        }
    });
    cursor.startBlinking();
}