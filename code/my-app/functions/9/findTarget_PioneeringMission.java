public static Location findTarget(AIUnit aiUnit, int range, boolean deferOK) {
    PathNode path = findTargetPath(aiUnit, range, false);
    if (path != null)
        return extractTarget(aiUnit, path);
    if (deferOK)
        return getBestPioneeringColony(aiUnit);
    Location loc = findCircleTarget(aiUnit, getGoalDecider(aiUnit, false), range * 3, false);
    return (hasTools(aiUnit)) ? loc : Location.upLoc(loc);
}