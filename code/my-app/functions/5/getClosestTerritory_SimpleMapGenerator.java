private Territory getClosestTerritory(final Tile tile, List<Territory> territories) {
    final Map map = tile.getMap();
    final Comparator<Territory> comp = Comparator.comparingInt(t -> map.getDistance(tile, t.getCenterTile(map)));
    return minimize(territories, comp);
}