public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    final AIUnit aiUnit = getAIUnit();
    if (aiUnit.hasCargo()) {
        Mission m = getEuropeanAIPlayer().getTransportMission(aiUnit);
        return lbDone(lb, m != null, " transporting");
    }
    String reason = invalidReason();
    if (isTargetReason(reason)) {
        return retargetMission(reason, lb);
    } else if (reason != null) {
        return lbFail(lb, false, reason);
    }
    final Unit unit = getUnit();
    if (unit.isInEurope()) {
        Settlement settlement = getBestSettlement(unit.getOwner());
        Tile tile = (settlement != null) ? settlement.getTile() : unit.getFullEntryLocation();
        unit.setDestination(tile);
        aiUnit.moveToAmerica();
    }
    if (unit.isAtSea())
        return lbAt(lb);
    Location newTarget = findTarget(aiUnit, 1, true);
    if (newTarget == null) {
        moveRandomlyTurn(tag);
        return lbAt(lb);
    }
    setTarget(newTarget);
    Unit.MoveType mt = travelToTarget(newTarget, null, lb);
    switch(mt) {
        case MOVE:
            break;
        case MOVE_HIGH_SEAS:
        case MOVE_NO_MOVES:
        case MOVE_ILLEGAL:
            return lbWait(lb);
        case MOVE_NO_REPAIR:
            return lbFail(lb, false, AIUNITDIED);
        case MOVE_NO_TILE:
            moveRandomly(tag, null);
            return lbDodge(lb);
        case ATTACK_UNIT:
            Direction direction = unit.getTile().getDirection(getTarget().getTile());
            if (direction != null) {
                AIMessage.askAttack(aiUnit, direction);
                lbAttack(lb, getTarget());
            } else {
                Location blocker = resolveBlockage(aiUnit, getTarget());
                if (blocker instanceof Unit && scoreUnit(aiUnit, (Unit) blocker) > 0) {
                    AIMessage.askAttack(aiUnit, unit.getTile().getDirection(blocker.getTile()));
                    lbAttack(lb, blocker);
                } else {
                    moveRandomlyTurn(tag);
                    lb.add(" avoiding ", blocker, ".");
                }
            }
            return this;
        case MOVE_NO_ACCESS_EMBARK:
        default:
            return lbMove(lb, mt);
    }
    return lbAt(lb);
}