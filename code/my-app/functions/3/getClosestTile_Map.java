public Tile getClosestTile(Tile tile, Collection<Tile> tiles) {
    return minimize(tiles, cachingIntComparator(t -> getDistance(t, tile)));
}