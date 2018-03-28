public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    final AIUnit aiUnit = getAIUnit();
    final Unit unit = getUnit();
    final IndianSettlement is = unit.getHomeIndianSettlement();
    Direction d;
    if (!this.demanded) {
        Unit.MoveType mt = travelToTarget(getTarget(), null, lb);
        switch(mt) {
            case MOVE_HIGH_SEAS:
            case MOVE_NO_MOVES:
            case MOVE_ILLEGAL:
                return lbWait(lb);
            case MOVE_NO_REPAIR:
                return lbFail(lb, false, AIUNITDIED);
            case MOVE_NO_TILE:
                return this;
            case ATTACK_SETTLEMENT:
                d = unit.getTile().getDirection(getTarget().getTile());
                if (d != null)
                    break;
            case ATTACK_UNIT:
                Location blocker = resolveBlockage(aiUnit, getTarget());
                if (blocker == null) {
                    moveRandomly(tag, null);
                    return lbWait(lb);
                }
                d = unit.getTile().getDirection(blocker.getTile());
                return (AIMessage.askAttack(aiUnit, d)) ? lbAttack(lb, blocker) : lbWait(lb);
            default:
                return lbMove(lb, mt);
        }
        lbAt(lb);
        AIPlayer aiPlayer = getAIPlayer();
        Colony colony = (Colony) getTarget();
        Player enemy = colony.getOwner();
        Goods goods = selectGoods(colony);
        GoodsType type = (goods == null) ? null : goods.getType();
        int amount = (goods == null) ? 0 : goods.getAmount();
        if (goods == null) {
            if (!enemy.checkGold(1)) {
                return lbDone(lb, false, "empty handed");
            }
            amount = enemy.getGold() / 20;
            if (amount == 0)
                amount = enemy.getGold();
        }
        this.demanded = AIMessage.askIndianDemand(aiPlayer, unit, colony, type, amount, null);
        lb.add(", demand made ", (this.demanded) ? "" : "un", "successfully");
        return lbWait(lb);
    } else if (!this.succeeded) {
        Colony colony = (Colony) getTarget();
        Player enemy = colony.getOwner();
        int unitTension = (is == null) ? 0 : is.getAlarm(enemy).getValue();
        int tension = Math.max(unitTension, unit.getOwner().getTension(enemy).getValue());
        d = unit.getTile().getDirection(colony.getTile());
        if (tension >= Tension.Level.CONTENT.getLimit() && d != null) {
            if (AIMessage.askAttack(aiUnit, d))
                lbAttack(lb, colony);
        }
        return lbDone(lb, false, "refused at ", colony);
    } else if (!hasTribute()) {
        return lbDone(lb, true, "accepted gold at ", colony);
    } else {
        for (; ; ) {
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
                case MOVE_NO_TILE:
                    return this;
                default:
                    return lbMove(lb, mt);
            }
            lbAt(lb);
            GoodsContainer container = unit.getGoodsContainer();
            for (Goods goods : container.getCompactGoods()) {
                Goods tribute = container.removeGoods(goods.getType());
                is.addGoods(tribute);
            }
            return lbDone(lb, false, "unloaded tribute");
        }
    }
}