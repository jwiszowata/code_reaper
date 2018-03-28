protected List<AIUnit> doMissions(List<AIUnit> aiUnits, LogBuilder lb) {
    lb.add("\n  Do Missions:");
    List<AIUnit> result = new ArrayList<>();
    for (AIUnit aiu : aiUnits) {
        final Unit unit = aiu.getUnit();
        if (unit == null || unit.isDisposed())
            continue;
        lb.add("\n  ", unit, " ");
        try {
            aiu.doMission(lb);
        } catch (Exception e) {
            logger.log(Level.WARNING, "doMissions failed for: " + aiu, e);
        }
        if (!unit.isDisposed() && unit.getMovesLeft() > 0)
            result.add(aiu);
    }
    return result;
}