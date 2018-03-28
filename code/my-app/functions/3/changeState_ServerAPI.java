public boolean changeState(Unit unit, UnitState state) {
    return ask(unit.getGame(), new ChangeStateMessage(unit, state));
}