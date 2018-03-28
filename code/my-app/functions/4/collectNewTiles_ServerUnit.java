public List<Tile> collectNewTiles(Tile tile) {
    final int los = getLineOfSight();
    return transform(tile.getSurroundingTiles(0, los), t -> !getOwner().canSee(t));
}