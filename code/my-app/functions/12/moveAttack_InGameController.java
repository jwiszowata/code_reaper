private boolean moveAttack(Unit unit, Direction direction) {
    Tile tile = unit.getTile();
    Tile target = tile.getNeighbourOrNull(direction);
    Unit u = target.getFirstUnit();
    if (u == null || unit.getOwner().owns(u))
        return false;
    askClearGotoOrders(unit);
    if (getGUI().confirmHostileAction(unit, target) && getGUI().confirmPreCombat(unit, target)) {
        askServer().attack(unit, direction);
    }
    return false;
}