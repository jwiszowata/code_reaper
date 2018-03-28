public boolean embark(Unit unit, Unit carrier, Direction direction) {
    return ask(unit.getGame(), new EmbarkMessage(unit, carrier, direction));
}