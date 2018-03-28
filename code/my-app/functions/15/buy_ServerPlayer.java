public int buy(GoodsContainer container, GoodsType type, int amount) {
    final Market market = getMarket();
    final int price = market.getBidPrice(type, amount);
    if (!checkGold(price))
        return -1;
    modifyGold(-price);
    market.modifySales(type, -amount);
    if (container != null)
        container.addGoods(type, amount);
    market.modifyIncomeBeforeTaxes(type, -price);
    market.modifyIncomeAfterTaxes(type, -price);
    int marketAmount = (int) applyModifiers((float) amount, getGame().getTurn(), Modifier.TRADE_BONUS, type);
    market.addGoodsToMarket(type, -marketAmount);
    return marketAmount;
}