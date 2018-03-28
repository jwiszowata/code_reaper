private List<ServerRegion> createLakeRegions(Map map, LogBuilder lb) {
    List<Tile> lakes = new ArrayList<>();
    lb.add("Lakes at:");
    for (int y = 0; y < map.getHeight(); y++) {
        for (int x = 0; x < map.getWidth(); x++) {
            Tile tile;
            if (map.isValid(x, y) && !(tile = map.getTile(x, y)).isLand() && map.getTile(x, y).getRegion() == null) {
                lakes.add(tile);
                lb.add(" ", x, ",", y);
            }
        }
    }
    lb.add("\n");
    return makeLakes(map, lakes);
}