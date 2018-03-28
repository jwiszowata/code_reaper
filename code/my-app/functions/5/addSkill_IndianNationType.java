private void addSkill(UnitType unitType, int probability) {
    if (skills == null)
        skills = new ArrayList<>();
    skills.add(new RandomChoice<>(unitType, probability));
}