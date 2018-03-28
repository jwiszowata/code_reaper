public static PathNode findTargetPath(AIUnit aiUnit, int range, boolean deferOK) {
    if (invalidAIUnitReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    final Location start = unit.getPathStartLocation();
    return unit.search(start, getGoalDecider(aiUnit, deferOK), CostDeciders.avoidIllegal(), range, null);
}