public Map build() {
    completeWorkingGrid();
    Map map = new Map(game, width, height);
    Region region = new Region(game);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            TileType tileType = tiles[x][y];
            Tile t = new Tile(game, tileType, x, y);
            t.setRegion(region);
            map.setTile(t, x, y);
        }
    }
    map.resetContiguity();
    map.resetHighSeasCount();
    if (exploredByAll) {
        map.forEachTile(t -> {
            for (Player p : game.getLiveEuropeanPlayerList()) {
                t.setExplored(p, true);
            }
        });
    }
    return map;
}