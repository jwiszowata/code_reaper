private List<ServerRegion> createRivers(Map map, LogBuilder lb) {
    List<ServerRegion> result = new ArrayList<>();
    final TileImprovementType riverType = spec.getTileImprovementType("model.improvement.river");
    final int number = getApproximateLandCount() / mapOptions.getInteger(MapGeneratorOptions.RIVER_NUMBER);
    int counter = 0;
    HashMap<Tile, River> riverMap = new HashMap<>();
    List<River> rivers = new ArrayList<>();
    outer: for (int i = 0; i < number; i++) {
        for (int tries = 0; tries < 100; tries++) {
            Tile tile = map.getRandomLandTile(random);
            if (tile == null)
                break outer;
            if (!riverType.isTileTypeAllowed(tile.getType()))
                continue;
            if (!all(tile.getSurroundingTiles(1, 2), Tile::isLand))
                continue;
            if (riverMap.get(tile) == null) {
                ServerRegion riverRegion = new ServerRegion(game, RegionType.RIVER);
                River river = new River(map, riverMap, riverRegion, random);
                if (river.flowFromSource(tile)) {
                    lb.add("Created new river with length ", river.getLength(), "\n");
                    result.add(riverRegion);
                    rivers.add(river);
                    if (++counter >= number)
                        break;
                } else {
                    lb.add("Failed to generate river.\n");
                }
                break;
            }
        }
    }
    lb.add("Created ", counter, " rivers of maximum ", number, "\n");
    for (River river : rivers) {
        ServerRegion region = river.getRegion();
        int score = 2 * sum(river.getSections(), RiverSection::getSize);
        region.setScoreValue(score);
        lb.add("Created river region (length ", river.getLength(), ", score value ", score, ").\n");
    }
    return result;
}