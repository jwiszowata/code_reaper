public static Location extractTarget(AIUnit aiUnit, PathNode path) {
    if (path == null)
        return null;
    final Location loc = path.getLastNode().getLocation();
    Settlement settlement = loc.getSettlement();
    return (invalidReason(aiUnit, settlement) == null) ? settlement : null;
}