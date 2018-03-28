private List<Unit> setType(final BuildingType newBuildingType) {
    final Colony colony = getColony();
    colony.removeFeatures(buildingType);
    List<Unit> eject = new ArrayList<>();
    if (newBuildingType != null) {
        buildingType = newBuildingType;
        updateProductionType();
        colony.addFeatures(buildingType);
        eject.addAll(transform(getUnits(), u -> !canAddType(u.getType())));
    }
    int extra = getUnitCount() - getUnitCapacity() - eject.size();
    for (Unit unit : getUnitList()) {
        if (extra <= 0)
            break;
        if (!eject.contains(unit)) {
            eject.add(unit);
            extra -= 1;
        }
    }
    return eject;
}