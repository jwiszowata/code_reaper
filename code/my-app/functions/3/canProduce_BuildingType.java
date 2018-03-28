public boolean canProduce(GoodsType goodsType, UnitType unitType) {
    return goodsType != null && ProductionType.canProduce(goodsType, getAvailableProductionTypes(unitType == null));
}