public boolean putOutsideColony(Unit unit) {
    return ask(unit.getGame(), new PutOutsideColonyMessage(unit));
}