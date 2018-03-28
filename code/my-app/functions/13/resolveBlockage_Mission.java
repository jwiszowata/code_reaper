public static Location resolveBlockage(AIUnit aiUnit, Location target) {
    final Unit unit = aiUnit.getUnit();
    PathNode path = unit.findPath(target);
    Direction d = null;
    if (path != null && path.next != null) {
        Tile tile = path.next.getTile();
        Settlement settlement = tile.getSettlement();
        Location blocker = (settlement != null) ? settlement : tile.getDefendingUnit(unit);
        if (UnitSeekAndDestroyMission.invalidReason(aiUnit, blocker) == null)
            return blocker;
    }
    return null;
}