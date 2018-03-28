private boolean moveDiplomacy(Unit unit, Direction direction, DiplomaticTrade dt) {
    Settlement settlement = getSettlementAt(unit.getTile(), direction);
    if (settlement instanceof Colony) {
        final Colony colony = (Colony) settlement;
        if (colony.getOwner() == unit.getOwner().getREFPlayer())
            return false;
        return !askServer().diplomacy(unit, colony, dt);
    }
    return false;
}