public List<Building> getBuildings() {
    synchronized (buildingMap) {
        return new ArrayList<>(buildingMap.values());
    }
}