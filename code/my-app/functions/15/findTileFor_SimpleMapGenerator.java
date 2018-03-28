private Tile findTileFor(Map map, int row, int start, boolean startAtSea, LogBuilder lb) {
    Tile tile = null;
    Tile seas = null;
    int offset = (start == 0) ? 1 : -1;
    for (int x = start; 0 <= x && x < map.getWidth(); x += offset) {
        tile = map.getTile(x, row);
        if (tile.isDirectlyHighSeasConnected()) {
            seas = tile;
        } else if (tile.isLand()) {
            return (startAtSea) ? seas : tile;
        }
    }
    lb.add("No land in row ", row, ".\n");
    return null;
}