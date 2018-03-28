public MoveType getSimpleMoveType(Tile target) {
    return (!hasTile()) ? MoveType.MOVE_NO_TILE : getSimpleMoveType(getTile(), target);
}