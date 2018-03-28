public boolean learnSkill(Unit unit, Direction direction) {
    return ask(unit.getGame(), new LearnSkillMessage(unit, direction));
}