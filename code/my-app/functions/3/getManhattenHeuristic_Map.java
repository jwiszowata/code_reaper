private SearchHeuristic getManhattenHeuristic(Tile endTile) {
    return (Tile tile) -> tile.getDistanceTo(endTile);
}