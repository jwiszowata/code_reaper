public boolean scoutSettlement(Unit unit, Direction direction) {
    return ask(unit.getGame(), new ScoutIndianSettlementMessage(unit, direction));
}