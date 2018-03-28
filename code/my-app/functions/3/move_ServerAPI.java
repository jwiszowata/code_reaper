public boolean move(Unit unit, Direction direction) {
    return ask(unit.getGame(), new MoveMessage(unit, direction));
}