public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (isTargetReason(reason)) {
        return retargetMission(reason, lb);
    } else if (reason != null) {
        return lbFail(lb, false, reason);
    }
    final AIUnit aiUnit = getAIUnit();
    final Unit unit = getUnit();
    Direction d;
    Unit.MoveType mt = travelToTarget(getTarget(), CostDeciders.avoidSettlementsAndBlockingUnits(), lb);
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
            return this;
        case MOVE_NO_TILE:
            moveRandomly(tag, null);
            return lbDodge(lb);
        case ATTACK_UNIT:
            moveRandomly(tag, unit.getTile().getDirection(getTarget().getTile()));
            return lbDodge(lb);
        case ENTER_INDIAN_SETTLEMENT_WITH_SCOUT:
            d = unit.getTile().getDirection(getTarget().getTile());
            assert d != null && getTarget() instanceof IndianSettlement;
            if (AIMessage.askScoutSpeakToChief(aiUnit, (IndianSettlement) getTarget())) {
                lbDone(lb, true, "speak-with-chief at ", getTarget());
            } else {
                lbFail(lb, true, "unexpected failure to speak at ", getTarget());
            }
            break;
        case EXPLORE_LOST_CITY_RUMOUR:
            d = unit.getTile().getDirection(getTarget().getTile());
            assert d != null;
            if (AIMessage.askMove(aiUnit, d)) {
                lbDone(lb, true, "explore at ", getTarget());
            } else {
                lbFail(lb, true, "unexpected failure at ", getTarget());
            }
            break;
        default:
            return lbMove(lb, mt);
    }
    if (unit.isDisposed())
        return this;
    lbAt(lb);
    Location completed = getTarget();
    Location newTarget = findTarget(aiUnit, 20, false);
    if (newTarget == null || (completed instanceof Colony && newTarget == completed)) {
        if (completed instanceof Colony && canScoutNatives(aiUnit)) {
            aiUnit.equipForRole(getSpecification().getDefaultRole());
        }
        return lbFail(lb, false, ", found no targets");
    }
    setTarget(newTarget);
    return lbRetarget(lb);
}