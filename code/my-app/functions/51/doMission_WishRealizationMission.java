public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    final Unit unit = getUnit();
    Location target = getTarget();
    Unit.MoveType mt = travelToTarget(target, CostDeciders.avoidSettlementsAndBlockingUnits(), lb);
    switch(mt) {
        case MOVE:
            break;
        case MOVE_HIGH_SEAS:
        case MOVE_NO_MOVES:
        case MOVE_ILLEGAL:
            return lbWait(lb);
        case MOVE_NO_REPAIR:
            return lbFail(lb, false, AIUNITDIED);
        case MOVE_NO_ACCESS_EMBARK:
        case MOVE_NO_TILE:
            return this;
        default:
            return lbMove(lb, mt);
    }
    lbAt(lb);
    if (target instanceof Colony) {
        final AIMain aiMain = getAIMain();
        final Colony colony = (Colony) target;
        final AIUnit aiUnit = getAIUnit();
        final AIColony aiColony = aiMain.getAIColony(colony);
        final EuropeanAIPlayer owner = getEuropeanAIPlayer();
        aiColony.completeWish(wish, unit.toShortString(), lb);
        if (unit.getType().isOffensive()) {
            if (owner.getDefendSettlementMission(aiUnit, colony) != null) {
                lbDone(lb, true, "ready to defend, ", colony);
            } else {
                lbFail(lb, true, "unable to defend");
            }
        } else {
            aiColony.requestRearrange();
            if (owner.getWorkInsideColonyMission(aiUnit, aiColony) != null) {
                lbDone(lb, true, "ready to work ", colony);
            } else {
                lbFail(lb, true, "unable to work");
            }
        }
    } else {
        lbFail(lb, true, "broken wish ", wish);
    }
    this.wish = null;
    return lbDrop(lb);
}