public List<Unit> getAllUnitsList() {
    List<Unit> units = getUnitList();
    if (units.isEmpty())
        return getTile().getUnitList();
    units.addAll(getTile().getUnitList());
    return units;
}