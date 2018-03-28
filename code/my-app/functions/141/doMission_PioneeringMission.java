public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    final AIUnit aiUnit = getAIUnit();
    if (tileImprovementPlan != null) {
        if (tileImprovementPlan.isComplete()) {
            lbDone(lb, true, tileImprovementPlan.getType(), " at ", getTarget());
            setTarget(null);
        } else if (!tileImprovementPlan.validate()) {
            lbFail(lb, true, "abandoned invalid plan at ", getTarget(), "/", tileImprovementPlan);
            setTarget(null);
        }
    }
    String reason = invalidReason();
    if (isTargetReason(reason)) {
        return retargetMission(reason, lb);
    } else if (reason != null) {
        return lbFail(lb, false, reason);
    }
    final Unit unit = getUnit();
    final Player player = unit.getOwner();
    final EuropeanAIPlayer aiPlayer = getEuropeanAIPlayer();
    final CostDecider costDecider = CostDeciders.avoidSettlementsAndBlockingUnits();
    Location newTarget;
    if (!hasTools()) {
        Unit.MoveType mt = travelToTarget(getTarget(), costDecider, lb);
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
        if (aiUnit.equipForRole(getSpecification().getPioneerRole()) && hasTools()) {
            lb.add(", equips");
            newTarget = findTarget(aiUnit, 10, false);
            if (newTarget == null) {
                return lbFail(lb, false, "no pioneering target");
            }
        } else {
            lb.add(", fails to equip");
            newTarget = findTarget(aiUnit, 10, false);
            if (newTarget == null || Map.isSameLocation(newTarget, getTarget())) {
                return lbFail(lb, false, "no tools target");
            }
        }
        setTarget(newTarget);
        return lbRetarget(lb);
    }
    if (getTarget() instanceof Colony && invalidTargetReason(getTarget(), player) == null) {
        Unit.MoveType mt = travelToTarget(getTarget(), costDecider, lb);
        switch(mt) {
            case MOVE:
                break;
            case MOVE_HIGH_SEAS:
                return lbWait(lb);
            case MOVE_NO_REPAIR:
                return lbFail(lb, false, AIUNITDIED);
            case MOVE_NO_MOVES:
            case MOVE_NO_TILE:
            case MOVE_ILLEGAL:
                return this;
            default:
                return lbMove(lb, mt);
        }
        lbAt(lb);
        newTarget = findTarget(aiUnit, 10, false);
        if (newTarget == null) {
            return lbFail(lb, false, "found no pioneering target");
        }
        setTarget(newTarget);
        return lbRetarget(lb);
    }
    Tile tile = getTarget().getTile();
    for (; ; ) {
        Unit.MoveType mt = travelToTarget(getTarget(), costDecider, lb);
        switch(mt) {
            case MOVE:
                break;
            case MOVE_HIGH_SEAS:
                return lbWait(lb);
            case MOVE_NO_REPAIR:
                return lbFail(lb, false, AIUNITDIED);
            case MOVE_NO_MOVES:
            case MOVE_NO_TILE:
            case MOVE_ILLEGAL:
                return this;
            case MOVE_NO_ATTACK_CIVILIAN:
                Direction d = unit.getTile().getDirection(tile);
                if (d != null)
                    moveRandomly(tag, d);
                continue;
            default:
                return lbMove(lb, mt);
        }
        break;
    }
    lbAt(lb);
    if (!player.owns(tile)) {
        boolean fail;
        int price = player.getLandPrice(tile);
        if (price < 0) {
            fail = true;
        } else {
            if (price > 0 && !player.checkGold(price)) {
                price = Constants.STEAL_LAND;
            }
            fail = !AIMessage.askClaimLand(tile, aiUnit, price) || !player.owns(tile);
        }
        if (fail) {
            aiPlayer.removeTileImprovementPlan(tileImprovementPlan);
            tileImprovementPlan.dispose();
            lb.add(", land claim failed at ", tile);
            if ((newTarget = findTarget(aiUnit, 10, false)) == null) {
                return lbFail(lb, false, "no alternate target");
            }
            setTarget(newTarget);
            return lbRetarget(lb);
        }
    }
    if (unit.getState() == UnitState.IMPROVING) {
        return lbWait(lb, ", improving ", tileImprovementPlan);
    } else if (unit.checkSetState(UnitState.IMPROVING)) {
        aiPlayer.removeTileImprovementPlan(tileImprovementPlan);
        if (AIMessage.askChangeWorkImprovementType(aiUnit, tileImprovementPlan.getType())) {
            return lbWait(lb, ", began ", tileImprovementPlan);
        } else {
            tileImprovementPlan.dispose();
            return lbFail(lb, false, "to change work type at ", tile);
        }
    }
    return lbWait(lb, ", waiting to improve at ", tile);
}