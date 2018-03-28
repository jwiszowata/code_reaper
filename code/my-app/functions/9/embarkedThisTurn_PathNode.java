public boolean embarkedThisTurn(int turns) {
    for (PathNode p = this; p != null; p = p.previous) {
        if (p.getTurns() < turns)
            return false;
        if (!p.isOnCarrier())
            return true;
    }
    return false;
}