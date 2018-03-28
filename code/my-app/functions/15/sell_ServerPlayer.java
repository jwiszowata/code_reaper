public int sell(GoodsContainer container, GoodsType type, int amount) {
    final Market market = getMarket();
    final int tax = getTax();
    final int incomeBeforeTaxes = market.getSalePrice(type, amount);
    final int incomeAfterTaxes = ((100 - tax) * incomeBeforeTaxes) / 100;
    modifyGold(incomeAfterTaxes);
    market.modifySales(type, amount);
    if (container != null)
        container.addGoods(type, -amount);
    market.modifyIncomeBeforeTaxes(type, incomeBeforeTaxes);
    market.modifyIncomeAfterTaxes(type, incomeAfterTaxes);
    int marketAmount = (int) applyModifiers((float) amount, getGame().getTurn(), Modifier.TRADE_BONUS, type);
    market.addGoodsToMarket(type, marketAmount);
    return marketAmount;
}