public int getCostToBuy(GoodsType type) {
    MarketData data = getMarketData(type);
    return (data == null) ? 0 : data.getCostToBuy();
}