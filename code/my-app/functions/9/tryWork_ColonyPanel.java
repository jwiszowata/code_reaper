private boolean tryWork(Unit unit) {
    Building building = getBuilding();
    NoAddReason reason = building.getNoAddReason(unit);
    if (reason != NoAddReason.NONE) {
        getGUI().showInformationMessage(building, reason.getDescriptionKey());
        return false;
    }
    return ColonyPanel.this.tryWork(unit, building);
}