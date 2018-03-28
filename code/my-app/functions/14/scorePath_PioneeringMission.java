public static int scorePath(AIUnit aiUnit, PathNode path) {
    final Location loc = extractTarget(aiUnit, path);
    if (hasTools(aiUnit)) {
        TileImprovementPlan tip;
        if (loc instanceof Tile && (tip = getBestPlan(aiUnit, (Tile) loc)) != null) {
            return 1000 * tip.getValue() / (path.getTotalTurns() + 1);
        }
    } else {
        if (loc instanceof Colony) {
            return 1000 / (path.getTotalTurns() + 1);
        }
    }
    return Integer.MIN_VALUE;
}