public boolean askSkill(Unit unit, Direction direction) {
    return ask(unit.getGame(), new AskSkillMessage(unit, direction));
}