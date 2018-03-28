public int getSalePrice(GoodsType type, int amount) {
    MarketData data = getMarketData(type);
    return (data == null) ? 0 : amount * data.getPaidForSale();
}