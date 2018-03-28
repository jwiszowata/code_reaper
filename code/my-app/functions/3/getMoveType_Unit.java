public MoveType getMoveType(Tile target) {
    return (!hasTile()) ? MoveType.MOVE_NO_TILE : getMoveType(getTile(), target, getMovesLeft());
}