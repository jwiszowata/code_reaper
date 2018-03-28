public boolean install(Unit unit) {
    if (!unit.setLocation(workLocation))
        return false;
    if (productionType != workLocation.getProductionType()) {
        workLocation.setProductionType(productionType);
    }
    if (workType != unit.getWorkType()) {
        unit.changeWorkType(workType);
    }
    return true;
}