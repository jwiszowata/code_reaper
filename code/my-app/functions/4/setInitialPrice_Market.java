public void setInitialPrice(GoodsType goodsType, int amount) {
    MarketData data = requireMarketData(goodsType);
    data.setInitialPrice(amount);
}