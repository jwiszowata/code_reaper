public int getBaseProduction(ProductionType productionType, GoodsType goodsType, UnitType unitType) {
    final BuildingType type = getType();
    return (type == null) ? 0 : getType().getBaseProduction(productionType, goodsType, unitType);
}