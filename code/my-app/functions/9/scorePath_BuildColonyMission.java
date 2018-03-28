public static float scorePath(AIUnit aiUnit, PathNode path) {
    Location loc;
    if (path == null || !((loc = extractTarget(aiUnit, path)) instanceof Tile))
        return Integer.MIN_VALUE;
    final Tile tile = (Tile) loc;
    final Player player = aiUnit.getUnit().getOwner();
    float turns = path.getTotalTurns() + 1.0f;
    return player.getColonyValue(tile) / turns;
}