private List<ServerRegion> makeLakes(Map map, List<Tile> lakes) {
    Game game = map.getGame();
    final TileType lakeType = map.getSpecification().getTileType("model.tile.lake");
    List<Tile> todo = new ArrayList<>();
    List<ServerRegion> result = new ArrayList<>();
    int lakeCount = 0;
    while (!lakes.isEmpty()) {
        Tile tile = first(lakes);
        if (tile.getRegion() != null)
            continue;
        ServerRegion lakeRegion = new ServerRegion(game, RegionType.LAKE);
        todo.clear();
        todo.add(tile);
        while (!todo.isEmpty()) {
            Tile t = todo.remove(0);
            if (lakes.contains(t)) {
                t.setRegion(lakeRegion);
                t.setType(lakeType);
                lakes.remove(t);
                for (Direction d : Direction.allDirections) {
                    Tile t0 = map.getAdjacentTile(t, d);
                    if (t0 != null)
                        todo.add(t0);
                }
            }
        }
        result.add(lakeRegion);
    }
    return result;
}