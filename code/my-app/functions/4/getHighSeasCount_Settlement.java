public int getHighSeasCount() {
    Tile best = minimize(getTile().getSurroundingTiles(1, 1), Tile.isSeaTile, Tile.highSeasComparator);
    return (best == null) ? INFINITY : best.getHighSeasCount();
}