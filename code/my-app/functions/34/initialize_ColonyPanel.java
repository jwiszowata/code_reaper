public void initialize() {
    final Colony colony = getColony();
    if (colony == null)
        return;
    cleanup();
    Tile tile = colony.getTile();
    tiles[0][0] = tile.getNeighbourOrNull(Direction.N);
    tiles[0][1] = tile.getNeighbourOrNull(Direction.NE);
    tiles[0][2] = tile.getNeighbourOrNull(Direction.E);
    tiles[1][0] = tile.getNeighbourOrNull(Direction.NW);
    tiles[1][1] = tile;
    tiles[1][2] = tile.getNeighbourOrNull(Direction.SE);
    tiles[2][0] = tile.getNeighbourOrNull(Direction.W);
    tiles[2][1] = tile.getNeighbourOrNull(Direction.SW);
    tiles[2][2] = tile.getNeighbourOrNull(Direction.S);
    int layer = 2;
    for (int x = 0; x < 3; x++) {
        for (int y = 0; y < 3; y++) {
            if (tiles[x][y] == null) {
                logger.warning("Null tile for " + getColony() + " at " + x + "," + y);
                continue;
            }
            ColonyTile colonyTile = colony.getColonyTile(tiles[x][y]);
            if (colonyTile == null) {
                logger.warning("Null colony tile for " + getColony() + " on " + tiles[x][y] + " at " + x + "," + y);
                continue;
            }
            ASingleTilePanel aSTP = new ASingleTilePanel(colonyTile, x, y);
            aSTP.initialize();
            add(aSTP, Integer.valueOf(layer++));
        }
    }
    update();
}