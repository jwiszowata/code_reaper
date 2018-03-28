private boolean moveSpy(Unit unit, Direction direction) {
    Settlement settlement = getSettlementAt(unit.getTile(), direction);
    return (settlement instanceof Colony) ? askServer().spy(unit, settlement) : false;
}