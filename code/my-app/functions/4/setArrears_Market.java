public void setArrears(GoodsType goodsType, int value) {
    MarketData data = requireMarketData(goodsType);
    data.setArrears(value);
}