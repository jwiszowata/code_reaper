public static String prepare(AIUnit aiUnit) {
    String reason = invalidReason(aiUnit);
    if (reason != null)
        return reason;
    final Unit unit = aiUnit.getUnit();
    if (!hasTools(aiUnit) && !aiUnit.equipForRole(unit.getSpecification().getPioneerRole())) {
        return "unit-could-not-equip";
    }
    return (hasTools(aiUnit) || unit.hasAbility(Ability.EXPERT_PIONEER)) ? null : "unit-missing-tools";
}