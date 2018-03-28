public Mission doMission(LogBuilder lb) {
    lb.add(tag);
    String reason = invalidReason();
    if (reason != null)
        return lbFail(lb, false, reason);
    final Unit unit = getUnit();
    final AIUnit aiUnit = getAIUnit();
    int check = 0, checkTurns = randomInt(logger, "Hostile", getAIRandom(), 4);
    Direction d = Direction.getRandomDirection(tag, logger, getAIRandom());
    while (unit.getMovesLeft() > 0) {
        if (check == 0) {
            Mission m = getAIPlayer().getSeekAndDestroyMission(aiUnit, 1);
            if (m != null) {
                return lbDone(lb, true, "found target ", m.getTarget());
            }
            check = checkTurns;
        } else
            check--;
        if ((d = moveRandomly(tag, d)) == null)
            break;
    }
    return lbAt(lb);
}