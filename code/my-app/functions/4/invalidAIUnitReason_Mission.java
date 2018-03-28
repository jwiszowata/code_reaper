public static String invalidAIUnitReason(AIUnit aiUnit) {
    String reason;
    return (aiUnit == null) ? AIUNITNULL : ((reason = invalidUnitReason(aiUnit.getUnit())) != null) ? reason : null;
}