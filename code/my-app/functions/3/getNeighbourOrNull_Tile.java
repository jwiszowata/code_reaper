public Tile getNeighbourOrNull(Direction direction) {
    return getMap().getAdjacentTile(x, y, direction);
}