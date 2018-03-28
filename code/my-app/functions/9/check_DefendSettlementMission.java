public boolean check(Unit u, PathNode path) {
    int value = scorePath(aiUnit, path);
    if (bestValue < value) {
        bestValue = value;
        bestPath = path;
        return true;
    }
    return false;
}