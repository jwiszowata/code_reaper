public void initialize() {
    final Colony colony = getColony();
    if (colony == null)
        return;
    cleanup();
    for (Building building : sort(colony.getBuildings())) {
        ASingleBuildingPanel aSBP = new ASingleBuildingPanel(building);
        aSBP.initialize();
        add(aSBP);
    }
    update();
}