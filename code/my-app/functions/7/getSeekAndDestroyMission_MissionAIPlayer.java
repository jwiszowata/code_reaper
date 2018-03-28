public Mission getSeekAndDestroyMission(AIUnit aiUnit, int range) {
    Location loc = null;
    if (UnitSeekAndDestroyMission.invalidReason(aiUnit) == null) {
        loc = UnitSeekAndDestroyMission.findTarget(aiUnit, range, false);
    }
    return (loc == null) ? null : getSeekAndDestroyMission(aiUnit, loc);
}