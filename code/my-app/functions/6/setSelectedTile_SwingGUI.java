public boolean setSelectedTile(Tile newTileToSelect) {
    boolean result = mapViewer.setSelectedTile(newTileToSelect);
    updateMapControls();
    updateMenuBar();
    return result;
}