private static String invalidMissionReason(AIUnit aiUnit) {
    String reason = invalidAIUnitReason(aiUnit);
    if (reason != null)
        return reason;
    final Unit unit = aiUnit.getUnit();
    final CombatModel cm = unit.getGame().getCombatModel();
    return (cm.getDefencePower(null, unit) <= 0.0f) ? "unit-not-defender" : null;
}