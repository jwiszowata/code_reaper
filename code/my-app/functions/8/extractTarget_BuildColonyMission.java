public static Location extractTarget(AIUnit aiUnit, PathNode path) {
    if (path == null)
        return null;
    final Location loc = path.getLastNode().getLocation();
    Tile tile = loc.getTile();
    Colony colony = loc.getColony();
    return (invalidReason(aiUnit, tile) == null) ? tile : (invalidReason(aiUnit, colony) == null) ? colony : null;
}