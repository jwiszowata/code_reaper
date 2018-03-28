public Building getBuilding(BuildingType type) {
    synchronized (buildingMap) {
        return buildingMap.get(type.getFirstLevel().getId());
    }
}