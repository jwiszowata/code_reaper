private static String invalidMissionReason(AIUnit aiUnit) {
    final Unit unit = aiUnit.getUnit();
    return (!unit.isOffensiveUnit()) ? Mission.UNITNOTOFFENSIVE : (!unit.hasTile()) ? Mission.UNITNOTONMAP : null;
}