public int getInitialPrice(GoodsType goodsType) {
    MarketData data = requireMarketData(goodsType);
    return data.getInitialPrice();
}