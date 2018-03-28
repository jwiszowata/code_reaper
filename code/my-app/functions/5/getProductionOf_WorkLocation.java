public int getProductionOf(Unit unit, GoodsType goodsType) {
    if (unit == null)
        throw new IllegalArgumentException("Null unit.");
    return (!produces(goodsType)) ? 0 : Math.max(0, getPotentialProduction(goodsType, unit.getType()));
}