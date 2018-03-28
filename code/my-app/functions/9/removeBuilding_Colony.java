protected boolean removeBuilding(final Building building) {
    final BuildingType buildingType = building.getType().getFirstLevel();
    synchronized (buildingMap) {
        if (buildingMap.remove(buildingType.getId()) == null)
            return false;
    }
    removeFeatures(building.getType());
    return true;
}