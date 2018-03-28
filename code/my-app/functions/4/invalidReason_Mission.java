public static String invalidReason(AIUnit aiUnit, Location loc) {
    String reason = invalidAIUnitReason(aiUnit);
    return (reason != null) ? reason : invalidTargetReason(loc);
}