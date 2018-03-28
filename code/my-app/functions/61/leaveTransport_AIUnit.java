public boolean leaveTransport() {
    if (!unit.isOnCarrier())
        return true;
    if (unit.isInEurope())
        return leaveTransport(null);
    final Tile tile = unit.getTile();
    if (tile == null)
        return false;
    final Mission mission = getMission();
    final Location target = (mission == null || !mission.isValid()) ? null : mission.getTarget();
    Direction direction;
    if (target != null) {
        if (Map.isSameLocation(target, tile))
            return leaveTransport(null);
        if (target.getTile() != null && (direction = tile.getDirection(target.getTile())) != null) {
            return leaveTransport(direction);
        }
        PathNode path = unit.findPath(target);
        if (path != null && (direction = tile.getDirection(path.next.getTile())) != null) {
            try {
                return leaveTransport(direction);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Leave transport crash for " + this + "/" + unit.getMovesLeft(), e);
            }
        }
    }
    if (tile.isLand())
        return leaveTransport(null);
    List<Tile> tiles = new ArrayList<>();
    for (Tile t : tile.getSurroundingTiles(1)) {
        if (!t.isBlocked(unit)) {
            if (t.getSettlement() != null) {
                return leaveTransport(tile.getDirection(t));
            }
            tiles.add(t);
        }
    }
    if (tiles.isEmpty())
        return false;
    final Player player = unit.getOwner();
    Tile safe = tiles.get(0);
    Tile best = null;
    int bestTurns = Unit.MANY_TURNS;
    Settlement settlement = null;
    for (Tile t : tiles) {
        if (settlement == null || t.isConnectedTo(settlement.getTile())) {
            settlement = t.getNearestSettlement(player, 10, true);
        }
        if (settlement != null) {
            int turns = unit.getTurnsToReach(t, settlement);
            if (bestTurns > turns) {
                bestTurns = turns;
                best = t;
            }
        }
        if (safe.getDefenceValue() < t.getDefenceValue()) {
            safe = t;
        }
    }
    return leaveTransport(tile.getDirection((best != null) ? best : safe));
}