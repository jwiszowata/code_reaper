public static int scorePath(AIUnit aiUnit, PathNode path) {
    Location loc = extractTarget(aiUnit, path);
    return (loc instanceof IndianSettlement) ? 1000 / (path.getTotalTurns() + 1) : Integer.MIN_VALUE;
}