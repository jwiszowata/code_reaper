public boolean check(Unit u, PathNode path) {
    Tile t = path.getTile();
    if (t != null && t.isAdjacent(tile)) {
        best = path;
        return true;
    }
    return false;
}