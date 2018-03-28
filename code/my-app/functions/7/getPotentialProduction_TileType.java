public int getPotentialProduction(GoodsType goodsType, UnitType unitType) {
    if (goodsType == null)
        return 0;
    int amount = getBaseProduction(null, goodsType, unitType);
    amount = (int) applyModifiers(amount, null, goodsType.getId(), unitType);
    return (amount < 0) ? 0 : amount;
}