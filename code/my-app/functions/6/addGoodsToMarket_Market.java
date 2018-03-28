public boolean addGoodsToMarket(GoodsType goodsType, int amount) {
    MarketData data = requireMarketData(goodsType);
    data.setAmountInMarket(Math.max(MINIMUM_AMOUNT, data.getAmountInMarket() + amount));
    data.setTraded(true);
    return data.price();
}