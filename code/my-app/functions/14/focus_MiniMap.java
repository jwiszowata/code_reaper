private void focus(int x, int y) {
    Map map = getMap();
    if (map == null)
        return;
    int tileX, tileY;
    if (adjustX > 0 && adjustY > 0) {
        tileX = ((x - adjustX) / tileSize) + firstColumn + adjustX / MIN_TILE_SIZE;
        tileY = ((y - adjustY) / tileSize * MIN_TILE_SIZE) + firstRow + adjustY;
    } else {
        tileX = ((x - adjustX) / tileSize) + firstColumn;
        tileY = ((y - adjustY) / tileSize * 4) + firstRow;
    }
    getGUI().setFocus(map.getTile(tileX, tileY));
}