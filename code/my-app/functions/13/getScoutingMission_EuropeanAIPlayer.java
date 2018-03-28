public Mission getScoutingMission(AIUnit aiUnit) {
    if (ScoutingMission.prepare(aiUnit) != null)
        return null;
    Location loc = ScoutingMission.findTarget(aiUnit, scoutingRange, true);
    if (loc == null) {
        Unit unit = aiUnit.getUnit();
        if (unit.isInEurope() || unit.getSettlement() != null) {
            aiUnit.equipForRole(getSpecification().getDefaultRole());
        }
        return null;
    }
    return new ScoutingMission(getAIMain(), aiUnit, loc);
}