public boolean check(Unit u, PathNode path) {
    Tile tile = path.getTile();
    if (tile == null)
        return false;
    for (Location loc : transform(locs, l -> tile.isAdjacent(l.getTile()))) {
        PathNode p = results.get(loc);
        if (p == null || p.getCost() > path.getCost()) {
            results.put(loc, path);
        }
    }
    return false;
}