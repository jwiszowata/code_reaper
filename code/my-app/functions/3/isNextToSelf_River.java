public boolean isNextToSelf(Tile tile) {
    return any(Direction.longSides, d -> this.contains(tile.getNeighbourOrNull(d)));
}