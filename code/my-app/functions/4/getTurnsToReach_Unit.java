public int getTurnsToReach(Location start, Location end, Unit carrier, CostDecider costDecider) {
    PathNode path = findPath(start, end, carrier, costDecider);
    return (path == null) ? MANY_TURNS : path.getTotalTurns();
}