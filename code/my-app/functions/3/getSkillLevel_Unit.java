public static int getSkillLevel(UnitType unitType) {
    return (unitType.hasSkill()) ? unitType.getSkill() : 0;
}