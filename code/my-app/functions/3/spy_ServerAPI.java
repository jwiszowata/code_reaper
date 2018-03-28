public boolean spy(Unit unit, Settlement settlement) {
    return ask(unit.getGame(), new SpySettlementMessage(unit, settlement));
}