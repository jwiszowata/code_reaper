public int getPotentialProduction(GoodsType goodsType, UnitType unitType) {
    if (!canProduce(goodsType, unitType))
        return 0;
    int amount = getBaseProduction(null, goodsType, unitType);
    amount = (int) applyModifiers(amount, getGame().getTurn(), getProductionModifiers(goodsType, unitType));
    return (amount < 0) ? 0 : amount;
}