private Occupation getOccupationFor(Unit unit, boolean userMode) {
    LogBuilder lb = new LogBuilder((getOccupationTrace()) ? 64 : 0);
    lb.add(getName(), ".getOccupationFor(", unit, ")");
    Occupation occupation = getOccupationFor(unit, userMode, lb);
    lb.log(logger, Level.WARNING);
    return occupation;
}