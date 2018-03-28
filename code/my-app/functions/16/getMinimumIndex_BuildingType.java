public int getMinimumIndex(Colony colony, JList<BuildableType> buildQueueList, int UNABLE_TO_BUILD) {
    ListModel<BuildableType> buildQueue = buildQueueList.getModel();
    BuildingType upgradesFrom = this.getUpgradesFrom();
    if (upgradesFrom == null)
        return 0;
    Building building = colony.getBuilding(this);
    BuildingType buildingType = (building == null) ? null : building.getType();
    if (buildingType == upgradesFrom)
        return 0;
    for (int index = 0; index < buildQueue.getSize(); index++) {
        if (upgradesFrom.equals(buildQueue.getElementAt(index))) {
            return index + 1;
        }
    }
    return UNABLE_TO_BUILD;
}