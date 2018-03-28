public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    moveRandomlyTurn(tag);
    return lbAt(lb);
}