void displayColonyTiles(Graphics2D g, Tile[][] tiles, Colony colony) {
    Set<String> overlayCache = ImageLibrary.createOverlayCache();
    Dimension tileSize = lib.tileSize;
    for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
            if (tiles[x][y] != null) {
                int xx = (((2 - x) + y) * tileSize.width) / 2;
                int yy = ((x + y) * tileSize.height) / 2;
                g.translate(xx, yy);
                BufferedImage overlayImage = lib.getOverlayImage(tiles[x][y], overlayCache);
                displayColonyTile(g, tiles[x][y], colony, overlayImage);
                g.translate(-xx, -yy);
            }
        }
    }
}