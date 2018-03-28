public static String invalidReason(AIUnit aiUnit) {
    String reason = invalidMissionReason(aiUnit);
    return (reason != null) ? reason : (!aiUnit.getUnit().getOwner().hasSettlements()) ? Mission.TARGETNOTFOUND : null;
}