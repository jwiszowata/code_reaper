private static PathNode findTargetPath(AIUnit aiUnit, int range, boolean deferOK) {
    if (invalidAIUnitReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    final Location start = unit.getPathStartLocation();
    final Unit carrier = unit.getCarrier();
    final GoalDecider gd = getGoalDecider(aiUnit, deferOK);
    final CostDecider standardCd = CostDeciders.avoidSettlementsAndBlockingUnits();
    return unit.search(start, gd, standardCd, range, carrier);
}