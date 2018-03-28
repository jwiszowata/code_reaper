public int getCost(Unit unit, Location oldLocation, Location newLocation, int movesLeft) {
    int cost = super.getCost(unit, oldLocation, newLocation, movesLeft);
    if (cost != ILLEGAL_MOVE && cost != Map.INFINITY) {
        Settlement settlement = newLocation.getSettlement();
        if (settlement != null && settlement.getOwner() != unit.getOwner()) {
            return ILLEGAL_MOVE;
        }
    }
    return cost;
}