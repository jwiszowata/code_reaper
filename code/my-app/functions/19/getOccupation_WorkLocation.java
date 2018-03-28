public Occupation getOccupation(Unit unit, boolean userMode) {
    LogBuilder lb = new LogBuilder((colony.getOccupationTrace()) ? 64 : 0);
    lb.add(colony.getName(), "/", this, ".getOccupation(", unit, ")");
    Occupation best = new Occupation(null, null, null);
    int bestAmount = 0;
    for (Collection<GoodsType> types : colony.getWorkTypeChoices(unit, userMode)) {
        lb.add("\n  ");
        logFreeColObjects(types, lb);
        bestAmount = best.improve(unit, this, bestAmount, types, lb);
        if (best.workType != null) {
            lb.add("\n  => ", best);
            break;
        }
    }
    if (best.workType == null)
        lb.add("\n  FAILED");
    lb.log(logger, Level.WARNING);
    return (best.workType == null) ? null : best;
}