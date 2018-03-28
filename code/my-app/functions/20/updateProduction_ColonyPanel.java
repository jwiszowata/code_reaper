private void updateProduction() {
    final Colony colony = getColony();
    if (colony == null)
        return;
    for (WorkLocation wl : colony.getCurrentWorkLocationsList()) {
        boolean change = false, check = wl.getProductionType() == null;
        for (Unit unit : transform(wl.getUnits(), u -> (check || !wl.produces(u.getWorkType())))) {
            GoodsType workType = wl.getWorkFor(unit);
            if (workType != null && workType != unit.getWorkType()) {
                change |= igc().changeWorkType(unit, workType);
            }
        }
        if (change)
            wl.updateProductionType();
    }
    updateTilesPanel();
    updateBuildingsPanel();
    updateNetProductionPanel();
    updateConstructionPanel();
}