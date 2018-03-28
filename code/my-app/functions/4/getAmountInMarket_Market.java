public int getAmountInMarket(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    return (data == null) ? 0 : data.getAmountInMarket();
}