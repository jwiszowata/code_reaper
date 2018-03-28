private boolean hasBuildingType(BuildingType buildingType) {
    while (true) {
        if (this.colony.getBuilding(buildingType) == null) {
            return false;
        } else if (colony.getBuilding(buildingType).getType() == buildingType) {
            return true;
        } else if (buildingType.getUpgradesTo() != null) {
            buildingType = buildingType.getUpgradesTo();
        } else {
            return false;
        }
    }
}