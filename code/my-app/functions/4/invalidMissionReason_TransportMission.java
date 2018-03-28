private static String invalidMissionReason(AIUnit aiUnit) {
    String reason = invalidAIUnitReason(aiUnit);
    return (reason != null) ? reason : (!aiUnit.getUnit().isCarrier()) ? "unit-not-a-carrier" : null;
}