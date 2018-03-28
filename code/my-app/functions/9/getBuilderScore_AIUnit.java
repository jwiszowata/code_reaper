public int getBuilderScore() {
    Unit unit = getUnit();
    if (unit == null || BuildColonyMission.invalidReason(this) != null)
        return -1000;
    int ret = (!unit.hasDefaultRole()) ? 0 : (unit.getSkillLevel() > 0) ? 100 : 500 + 100 * unit.getSkillLevel();
    if (unit.hasTile())
        ret += 50;
    return ret;
}