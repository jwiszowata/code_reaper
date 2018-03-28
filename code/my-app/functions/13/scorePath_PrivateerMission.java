public static int scorePath(AIUnit aiUnit, PathNode path) {
    Location loc = extractTarget(aiUnit, path);
    final int totalTurns = path.getTotalTurns() + 1;
    if (loc instanceof Europe || loc instanceof Colony) {
        return 1000 / totalTurns;
    } else if (loc instanceof Unit) {
        return scoreUnit(aiUnit, (Unit) loc) / totalTurns;
    } else if (loc instanceof Tile) {
        return 50 / totalTurns;
    } else {
        return Integer.MIN_VALUE;
    }
}