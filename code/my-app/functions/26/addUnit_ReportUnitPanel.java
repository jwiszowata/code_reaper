protected void addUnit(Unit unit, String key) {
    if (unit.getLocation() == null) {
        return;
    } else if (unit.isInEurope()) {
        inEurope.add(unit);
    } else {
        Colony colony = unit.getLocation().getColony();
        if (colony == null) {
            String locationName = getLocationLabelFor(unit);
            List<Unit> unitList = inLocations.get(locationName);
            if (unitList == null) {
                unitList = new ArrayList<>();
                inLocations.put(locationName, unitList);
            }
            unitList.add(unit);
        } else {
            List<Unit> unitList = inColonies.get(colony);
            if (unitList == null) {
                unitList = new ArrayList<>();
                inColonies.put(colony, unitList);
            }
            unitList.add(unit);
        }
    }
    incrementCount(key, unit.getType(), 1);
}