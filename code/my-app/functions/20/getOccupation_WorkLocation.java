public Occupation getOccupation(UnitType unitType) {
    final Specification spec = getSpecification();
    if (unitType == null) {
        unitType = spec.getDefaultUnitType(getOwner().getNationType());
    }
    LogBuilder lb = new LogBuilder((colony.getOccupationTrace()) ? 64 : 0);
    lb.add(colony.getName(), "/", this, ".getOccupation(", unitType.getSuffix(), ")");
    Collection<GoodsType> types = spec.getGoodsTypeList();
    Occupation best = new Occupation(null, null, null);
    lb.add("\n  ");
    logFreeColObjects(types, lb);
    int bestAmount = best.improve(unitType, this, 0, types, lb);
    if (best.workType != null) {
        lb.add("\n  => ", best, "/", bestAmount);
    } else {
        lb.add("\n  FAILED");
    }
    lb.log(logger, Level.WARNING);
    return (best.workType == null) ? null : best;
}