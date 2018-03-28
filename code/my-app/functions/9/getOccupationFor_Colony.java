private Occupation getOccupationFor(Unit unit, Collection<GoodsType> workTypes) {
    LogBuilder lb = new LogBuilder((getOccupationTrace()) ? 64 : 0);
    lb.add(getName(), ".getOccupationFor(", unit, ", ");
    FreeColObject.logFreeColObjects(workTypes, lb);
    lb.add(")");
    Occupation occupation = getOccupationFor(unit, workTypes, lb);
    lb.log(logger, Level.WARNING);
    return occupation;
}