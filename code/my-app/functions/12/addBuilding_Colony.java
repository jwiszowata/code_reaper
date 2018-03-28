public boolean addBuilding(final Building building) {
    if (building == null || building.getType() == null)
        return false;
    final BuildingType buildingType = building.getType().getFirstLevel();
    if (buildingType == null || buildingType.getId() == null)
        return false;
    synchronized (buildingMap) {
        buildingMap.put(buildingType.getId(), building);
    }
    addFeatures(building.getType());
    return true;
}