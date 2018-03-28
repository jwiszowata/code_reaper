public int improve(Unit unit, WorkLocation wl, int bestAmount, Collection<GoodsType> workTypes, LogBuilder lb) {
    boolean present = unit.getLocation() == wl;
    lb.add("\n    ", wl, ((!present && !wl.canAdd(unit)) ? " no-add" : ""));
    if (!present && !wl.canAdd(unit))
        return bestAmount;
    boolean alone = wl.getProductionType() == null || wl.isEmpty() || (present && wl.getUnitCount() == 1);
    return improve(unit.getType(), wl, bestAmount, workTypes, alone, lb);
}