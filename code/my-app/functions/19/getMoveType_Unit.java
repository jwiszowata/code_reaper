public MoveType getMoveType(Tile from, Tile target, int ml) {
    MoveType move = getSimpleMoveType(from, target);
    if (move.isLegal()) {
        switch(move) {
            case ATTACK_UNIT:
            case ATTACK_SETTLEMENT:
                if (ml <= 0) {
                    move = MoveType.MOVE_NO_MOVES;
                }
                break;
            default:
                if (ml <= 0 || (from != null && getMoveCost(from, target, ml) > ml)) {
                    move = MoveType.MOVE_NO_MOVES;
                }
                break;
        }
    }
    return move;
}