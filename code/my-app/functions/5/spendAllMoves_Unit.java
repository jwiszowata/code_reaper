private void spendAllMoves() {
    if (getColony() != null && getMovesLeft() < getInitialMovesLeft()) {
        setMovesLeft(0);
    }
}