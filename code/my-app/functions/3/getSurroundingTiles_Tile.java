public Iterable<Tile> getSurroundingTiles(int range) {
    return getMap().getCircleTiles(this, true, range);
}