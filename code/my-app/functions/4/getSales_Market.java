public int getSales(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    return (data == null) ? 0 : data.getSales();
}