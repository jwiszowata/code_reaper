public default default int getBaseProduction(ProductionType productionType, GoodsType goodsType, UnitType unitType) {
    if (goodsType == null)
        return 0;
    if (productionType == null) {
        productionType = ProductionType.getBestProductionType(goodsType, getAvailableProductionTypes(unitType == null));
    }
    if (productionType == null)
        return 0;
    AbstractGoods best = productionType.getOutput(goodsType);
    return (best == null) ? 0 : best.getAmount();
}