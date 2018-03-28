public boolean joinColony(Unit unit, Colony colony) {
    return ask(unit.getGame(), new JoinColonyMessage(colony, unit));
}