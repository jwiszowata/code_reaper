public boolean missionary(Unit unit, Direction direction, boolean denounce) {
    return ask(unit.getGame(), new MissionaryMessage(unit, direction, denounce));
}