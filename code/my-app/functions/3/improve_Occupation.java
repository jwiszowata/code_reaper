public int improve(UnitType unitType, WorkLocation wl, int bestAmount, Collection<GoodsType> workTypes, LogBuilder lb) {
    return improve(unitType, wl, bestAmount, workTypes, wl.isEmpty(), lb);
}