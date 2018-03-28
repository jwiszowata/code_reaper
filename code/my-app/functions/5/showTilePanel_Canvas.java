public void showTilePanel(Tile tile) {
    if (tile == null || !tile.isExplored())
        return;
    showSubPanel(new TilePanel(freeColClient, tile), false);
}