public boolean moveTo(Unit unit, Location destination) {
    return ask(unit.getGame(), new MoveToMessage(unit, destination));
}