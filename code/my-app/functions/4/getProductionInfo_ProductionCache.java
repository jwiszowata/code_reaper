public ProductionInfo getProductionInfo(Object object) {
    update();
    return productionAndConsumption.get(object);
}