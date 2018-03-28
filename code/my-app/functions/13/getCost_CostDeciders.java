public int getCost(Unit unit, Location oldLocation, Location newLocation, int movesLeft) {
    int cost = super.getCost(unit, oldLocation, newLocation, movesLeft);
    Tile tile = newLocation.getTile();
    if (cost != ILLEGAL_MOVE && cost != Map.INFINITY && tile != null) {
        final Unit defender = tile.getFirstUnit();
        if (defender != null && defender.getOwner() != unit.getOwner()) {
            return ILLEGAL_MOVE;
        } else if (unit.getTradeRoute() != null && tile.hasLostCityRumour()) {
            return ILLEGAL_MOVE;
        }
    }
    return cost;
}