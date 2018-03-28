public void refreshTile(Tile tile) {
    if (tile.getX() >= 0 && tile.getY() >= 0) {
        canvas.repaint(mapViewer.calculateTileBounds(tile));
    }
}