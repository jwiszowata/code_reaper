private void displayTileItem(Graphics2D g, Tile tile, TileItem item) {
    if (item instanceof TileImprovement) {
        displayTileImprovement(g, tile, (TileImprovement) item);
    } else if (item instanceof LostCityRumour) {
        displayLostCityRumour(g);
    } else {
        displayResourceTileItem(g, (Resource) item);
    }
}