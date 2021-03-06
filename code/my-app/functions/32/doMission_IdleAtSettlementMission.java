public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    if (isSafe()) {
        lb.add(", idling");
        return lbAt(lb);
    }
    Location target = getTarget();
    if (target == null) {
        moveRandomlyTurn(tag);
        return lbWait(lb);
    }
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
        case MOVE_NO_ACCESS_EMBARK:
        case MOVE_NO_TILE:
            return this;
        default:
            return lbMove(lb, mt);
    }
    return lbAt(lb);
}