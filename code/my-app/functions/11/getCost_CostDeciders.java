public int getCost(Unit unit, Location oldLocation, Location newLocation, int movesLeft) {
    int cost = super.getCost(unit, oldLocation, newLocation, movesLeft);
    if (cost != ILLEGAL_MOVE && cost != Map.INFINITY) {
        if (newLocation instanceof Europe) {
            ;
        } else if (!newLocation.getTile().isExploredBy(unit.getOwner())) {
            return ILLEGAL_MOVE;
        }
    }
    return cost;
}