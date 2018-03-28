public static PathNode findTargetPath(AIUnit aiUnit, int range, boolean deferOK) {
    if (invalidAIUnitReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    final Location start = unit.getPathStartLocation();
    return unit.search(start, getGoalDecider(aiUnit, false), CostDeciders.avoidIllegal(), range, unit.getCarrier());
}