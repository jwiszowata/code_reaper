protected void moveRandomlyTurn(String logMe) {
    Direction direction = null;
    while ((direction = moveRandomly(logMe, direction)) != null) {
    }
    getUnit().setMovesLeft(0);
}