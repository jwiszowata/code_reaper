public BuildingType getFirstLevel() {
    BuildingType buildingType = this;
    while (buildingType.getUpgradesFrom() != null) {
        buildingType = buildingType.getUpgradesFrom();
    }
    return buildingType;
}