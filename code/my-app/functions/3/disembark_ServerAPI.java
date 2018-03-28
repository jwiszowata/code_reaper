public boolean disembark(Unit unit) {
    return ask(unit.getGame(), new DisembarkMessage(unit));
}