public int getBidPrice(GoodsType type, int amount) {
    MarketData data = getMarketData(type);
    return (data == null) ? 0 : amount * data.getCostToBuy();
}