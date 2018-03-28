private void setStartingParams() {
    width = 20;
    height = 15;
    baseTile = spec().getTileType("model.tile.plains");
    exploredByAll = false;
    initiated = false;
    if (tiles == null) {
        tiles = new TileType[width][height];
    }
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            tiles[x][y] = null;
        }
    }
}