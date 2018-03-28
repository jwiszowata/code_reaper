private void displayTile(Graphics2D g, Tile tile, BufferedImage overlayImage) {
    displayTileWithBeachAndBorder(g, tile);
    if (tile.isExplored()) {
        displayTileItems(g, tile, overlayImage);
        displaySettlementWithChipsOrPopulationNumber(g, tile, false);
        displayFogOfWar(g, tile);
        displayOptionalTileText(g, tile);
    }
}