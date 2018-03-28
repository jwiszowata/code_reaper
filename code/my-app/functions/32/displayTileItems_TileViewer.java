void displayTileItems(Graphics2D g, Tile tile, BufferedImage overlayImage) {
    List<TileItem> tileItems = tile.getCompleteItems();
    int startIndex = 0;
    for (int index = startIndex; index < tileItems.size(); index++) {
        if (tileItems.get(index).getZIndex() < Tile.OVERLAY_ZINDEX) {
            displayTileItem(g, tile, tileItems.get(index));
            startIndex = index + 1;
        } else {
            startIndex = index;
            break;
        }
    }
    if (overlayImage != null) {
        g.drawImage(overlayImage, 0, (tileHeight - overlayImage.getHeight()), null);
    }
    for (int index = startIndex; index < tileItems.size(); index++) {
        if (tileItems.get(index).getZIndex() < Tile.FOREST_ZINDEX) {
            displayTileItem(g, tile, tileItems.get(index));
            startIndex = index + 1;
        } else {
            startIndex = index;
            break;
        }
    }
    if (tile.isForested()) {
        BufferedImage forestImage = lib.getForestImage(tile.getType(), tile.getRiverStyle());
        g.drawImage(forestImage, 0, (tileHeight - forestImage.getHeight()), null);
    }
    for (TileItem ti : tileItems.subList(startIndex, tileItems.size())) {
        displayTileItem(g, tile, ti);
    }
}