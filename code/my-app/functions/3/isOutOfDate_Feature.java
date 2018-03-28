public boolean isOutOfDate(Turn turn) {
    return turn != null && lastTurn != null && turn.getNumber() > lastTurn.getNumber();
}