public int getBaseProduction(ProductionType productionType, GoodsType goodsType, UnitType unitType) {
    if (type == null || goodsType == null || !goodsType.isFarmed())
        return 0;
    int amount = type.getBaseProduction(productionType, goodsType, unitType);
    return (amount < 0) ? 0 : amount;
}