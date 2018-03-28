private static PathNode findTargetPath(AIUnit aiUnit, int range, boolean deferOK) {
    if (invalidAIUnitReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    final Location start = unit.getPathStartLocation();
    final Player player = unit.getOwner();
    final Europe europe = player.getEurope();
    final Unit carrier = unit.getCarrier();
    final CostDecider standardCd = CostDeciders.avoidSettlementsAndBlockingUnits();
    if (!player.hasSettlements() || start == null) {
        return (europe == null) ? null : unit.findPath(unit.getLocation(), europe, carrier, standardCd);
    }
    return unit.search(start, getGoalDecider(aiUnit, deferOK), standardCd, range, carrier);
}