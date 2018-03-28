public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    checkCargoes(lb);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    final AIUnit aiCarrier = getAIUnit();
    final Unit unit = getUnit();
    final CostDecider fallBackDecider = CostDeciders.avoidSettlementsAndBlockingUnits();
    final EuropeanAIPlayer euaip = getEuropeanAIPlayer();
    CostDecider costDecider = CostDeciders.defaultCostDeciderFor(unit);
    for (; ; ) {
        Unit.MoveType mt = travelToTarget(target, costDecider, lb);
        switch(mt) {
            case MOVE:
                doTransport(lb);
                if (isEmpty() && unit.isOffensiveUnit()) {
                    Mission m = euaip.getPrivateerMission(aiCarrier, null);
                    if (m != null)
                        return lbDone(lb, false, "going pirate");
                }
                if ((reason = invalidReason()) != null) {
                    logger.warning(tag + " post-stop failure(" + reason + "): " + this.toFullString());
                    return lbFail(lb, false, reason);
                }
                if (unit.isAtLocation(target)) {
                    return lbWait(lb, ", waiting at ", target);
                }
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
                Location blocker = resolveBlockage(aiCarrier, target);
                if (blocker instanceof Unit && shouldAttack((Unit) blocker)) {
                    AIMessage.askAttack(aiCarrier, unit.getTile().getDirection(blocker.getTile()));
                    return lbAttack(lb, blocker);
                }
            case MOVE_NO_ATTACK_CIVILIAN:
                if (unit.getTile().isAdjacent(target.getTile()) || costDecider == fallBackDecider) {
                    moveRandomly(tag, null);
                    return lbDodge(lb);
                }
                costDecider = fallBackDecider;
                lb.add(", retry blockage at ", unit.getLocation());
                break;
            case MOVE_NO_ACCESS_EMBARK:
            default:
                return lbMove(lb, mt);
        }
    }
}