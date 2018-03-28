public boolean check(Unit u, PathNode path) {
    Tile t = path.getTile();
    if (t == null || !t.isLand())
        return false;
    Settlement s = t.getSettlement();
    if (s == null)
        return false;
    if (enemies.contains(s.getOwner())) {
        best = path;
        return true;
    }
    return false;
}