public int getArrears(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    return (data == null) ? 0 : data.getArrears();
}