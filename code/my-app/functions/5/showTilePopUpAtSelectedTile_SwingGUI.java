public void showTilePopUpAtSelectedTile() {
    Tile tile = mapViewer.getSelectedTile();
    Point point = mapViewer.calculateTilePosition(tile);
    canvas.showTilePopup(tile, point.x + mapViewer.getTileWidth(), point.y);
}