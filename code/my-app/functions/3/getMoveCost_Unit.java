public int getMoveCost(Tile target) {
    return getMoveCost(getTile(), target, getMovesLeft());
}