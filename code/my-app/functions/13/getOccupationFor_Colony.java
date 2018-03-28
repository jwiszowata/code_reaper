private Occupation getOccupationFor(Unit unit, Collection<GoodsType> workTypes, LogBuilder lb) {
    if (workTypes.isEmpty())
        return null;
    Occupation best = new Occupation(null, null, null);
    int bestAmount = 0;
    for (WorkLocation wl : getCurrentWorkLocationsList()) {
        bestAmount = best.improve(unit, wl, bestAmount, workTypes, lb);
    }
    if (best.workLocation != null) {
        lb.add("\n  => ", best, " = ", bestAmount);
    }
    return (best.workLocation == null) ? null : best;
}