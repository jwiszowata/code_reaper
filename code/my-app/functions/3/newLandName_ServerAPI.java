public boolean newLandName(Unit unit, String name) {
    return ask(unit.getGame(), new NewLandNameMessage(unit, name));
}