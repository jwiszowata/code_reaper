public void showTilePopup(Tile tile, int x, int y) {
    if (tile == null)
        return;
    TilePopup tp = new TilePopup(freeColClient, this, tile);
    if (tp.hasItem()) {
        tp.show(this, x, y);
        tp.repaint();
    } else if (tile.isExplored()) {
        showTilePanel(tile);
    }
}