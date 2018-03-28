public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    final AIUnit aiUnit = getAIUnit();
    final Unit unit = getUnit();
    final IndianSettlement is = unit.getHomeIndianSettlement();
    while (!this.collected) {
        Unit.MoveType mt = travelToTarget(getTarget(), null, lb);
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
                return this;
            case ATTACK_SETTLEMENT:
            case ATTACK_UNIT:
                Location blocker = resolveBlockage(aiUnit, getTarget());
                if (blocker != null && AIMessage.askAttack(aiUnit, unit.getTile().getDirection(blocker.getTile()))) {
                    return lbAttack(lb, blocker);
                }
                moveRandomly(tag, null);
                continue;
            default:
                return lbMove(lb, mt);
        }
        lbAt(lb);
        Goods gift = is.getRandomGift(getAIRandom());
        if (gift == null)
            return lbFail(lb, false, "found no gift");
        if (!AIMessage.askLoadGoods(is, gift.getType(), gift.getAmount(), aiUnit) || !hasGift()) {
            return lbFail(lb, false, "failed to collect gift");
        }
        this.collected = true;
        lb.add(", collected gift");
        return lbRetarget(lb);
    }
    for (; ; ) {
        Unit.MoveType mt = travelToTarget(getTarget(), CostDeciders.avoidSettlementsAndBlockingUnits(), lb);
        switch(mt) {
            case MOVE_HIGH_SEAS:
            case MOVE_NO_MOVES:
            case MOVE_ILLEGAL:
                return lbWait(lb);
            case MOVE_NO_REPAIR:
                return lbFail(lb, false, AIUNITDIED);
            case MOVE_NO_TILE:
                return this;
            case MOVE:
            case ATTACK_SETTLEMENT:
                break;
            case ATTACK_UNIT:
                Location blocker = resolveBlockage(aiUnit, getTarget());
                if (blocker != null && AIMessage.askAttack(aiUnit, unit.getTile().getDirection(blocker.getTile()))) {
                    return lbAttack(lb, blocker);
                }
                moveRandomly(tag, null);
                continue;
            default:
                return lbMove(lb, mt);
        }
        lbAt(lb);
        boolean result = AIMessage.askNativeGift(aiUnit, this.colony);
        return (result) ? lbDone(lb, false, "delivered") : lbFail(lb, false, "delivery");
    }
}