public boolean declineMounds(Unit unit, Direction direction) {
    return ask(unit.getGame(), new DeclineMoundsMessage(unit, direction));
}