public Mission getMissionaryMission(AIUnit aiUnit) {
    if (MissionaryMission.prepare(aiUnit) != null)
        return null;
    Location loc = MissionaryMission.findTarget(aiUnit, missionaryRange, true);
    if (loc == null) {
        aiUnit.equipForRole(getSpecification().getDefaultRole());
        return null;
    }
    return new MissionaryMission(getAIMain(), aiUnit, loc);
}