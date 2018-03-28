public boolean joinColony(Unit unit) {
    boolean ret;
    Occupation occupation = getOccupationFor(unit, false);
    if (occupation == null) {
        if (!traceOccupation) {
            LogBuilder lb = new LogBuilder(64);
            getOccupationFor(unit, false, lb);
            lb.log(logger, Level.WARNING);
        }
        ret = false;
    } else {
        ret = occupation.install(unit);
    }
    if (!ret) {
        unit.setLocation(getTile());
        logger.warning("Failed to join " + getName() + ": " + unit);
    }
    return ret;
}