public boolean attack(Unit unit, Direction direction) {
    return ask(unit.getGame(), new AttackMessage(unit, direction));
}