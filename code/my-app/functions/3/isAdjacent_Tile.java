public boolean isAdjacent(Tile tile) {
    return (tile == null) ? false : any(getSurroundingTiles(1, 1), matchKey(tile));
}