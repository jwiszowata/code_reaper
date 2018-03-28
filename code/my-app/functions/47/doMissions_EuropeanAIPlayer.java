protected List<AIUnit> doMissions(List<AIUnit> aiUnits, LogBuilder lb) {
    lb.add("\n  Do missions:");
    List<AIUnit> result = new ArrayList<>();
    for (AIUnit aiu : aiUnits) {
        final Unit unit = aiu.getUnit();
        if (unit == null || unit.isDisposed())
            continue;
        final Mission oldMission = aiu.getMission();
        if (oldMission == null) {
            result.add(aiu);
            continue;
        }
        final Location oldTarget = oldMission.getTarget();
        final Location oldLocation = unit.getLocation();
        final Colony oldColony = oldLocation.getColony();
        lb.add("\n  ", unit, " ");
        try {
            aiu.doMission(lb);
        } catch (Exception e) {
            lb.add(", EXCEPTION: ", e.getMessage());
            logger.log(Level.WARNING, "doMissions failed for: " + aiu, e);
        }
        if (unit.isDisposed() || unit.getLocation() == null) {
            aiu.dropTransport();
            lb.add(", DIED.");
            continue;
        }
        updateTransport(aiu, oldTarget, lb);
        if (unit.isDisposed() || unit.getLocation() == null) {
            lb.add(", DIED.");
            continue;
        }
        if (unit.getMovesLeft() > 0 && (!unit.isOnCarrier() || unit.getCarrier().getMovesLeft() > 0)) {
            lb.add("+");
            result.add(aiu);
        } else {
            lb.add(".");
        }
        Colony newColony = unit.getLocation().getColony();
        if (oldColony == null && newColony != null && Map.isSameLocation(oldLocation, newColony)) {
            AIColony aiColony = getAIColony(newColony);
            aiColony.update(lb);
            updateTipMap(aiColony);
        }
    }
    return result;
}