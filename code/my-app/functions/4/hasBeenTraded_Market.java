public boolean hasBeenTraded(GoodsType type) {
    MarketData data = getMarketData(type);
    return data != null && data.getTraded();
}