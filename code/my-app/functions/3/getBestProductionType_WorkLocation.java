public ProductionType getBestProductionType(boolean unattended, GoodsType workType) {
    return ProductionType.getBestProductionType(workType, getAvailableProductionTypes(unattended));
}