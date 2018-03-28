protected boolean isReportable(Unit unit) {
    return !unit.isNaval() && (unit.hasAbility(Ability.EXPERT_SOLDIER) || unit.isOffensiveUnit());
}