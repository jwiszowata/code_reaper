private static String invalidMissionReason(AIUnit aiUnit) {
    String reason = invalidAIUnitReason(aiUnit);
    return (reason != null) ? reason : (!canScoutNatives(aiUnit)) ? "unit-not-a-SCOUT" : null;
}