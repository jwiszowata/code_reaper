private void addStartingUnit(String id, AbstractUnit unit, boolean expert) {
    String exTag = (expert) ? Boolean.TRUE.toString() : null;
    Map<String, AbstractUnit> units = startingUnitMap.get(exTag);
    if (units == null) {
        units = new HashMap<>();
        startingUnitMap.put(exTag, units);
    }
    units.put(id, unit);
}