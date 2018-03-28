public boolean demandTribute(Unit unit, Direction direction) {
    return ask(unit.getGame(), new DemandTributeMessage(unit, direction));
}