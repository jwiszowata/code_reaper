public PathNode findOurNearestPort() {
    PathNode ePath = null;
    int eTurns = -1;
    Europe europe = getOwner().getEurope();
    if (getType().canMoveToHighSeas()) {
        ePath = (europe == null) ? null : findPath(europe);
        eTurns = (ePath == null) ? -1 : ePath.getTotalTurns();
    }
    PathNode sPath = findOurNearestSettlement(false, INFINITY, true);
    int sTurns = (sPath == null) ? -1 : sPath.getTotalTurns();
    return (ePath == null) ? sPath : (sPath == null) ? ePath : (sTurns <= eTurns) ? sPath : ePath;
}