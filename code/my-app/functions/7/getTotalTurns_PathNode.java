public int getTotalTurns() {
    PathNode path = getLastNode();
    int n = path.getTurns();
    if (path.getMovesLeft() == 0)
        n++;
    return n;
}