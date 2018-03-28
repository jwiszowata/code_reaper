public Mission retargetMission(String reason, LogBuilder lb) {
    lb.add(", failing(", reason, ")");
    Location newTarget = findTarget();
    if (newTarget != null) {
        setTarget(newTarget);
        return lbRetarget(lb);
    }
    lb.add(", retarget failed");
    return lbDrop(lb);
}