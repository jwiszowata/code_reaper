public boolean check(Unit u, PathNode path) {
    int cost;
    if (Map.isSameLocation(path.getLocation(), target)) {
        if ((cost = path.getCost()) < bestCost) {
            best = path;
            bestCost = cost;
        }
        return true;
    }
    return false;
}