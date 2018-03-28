private MarketData requireMarketData(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    if (data == null) {
        data = new MarketData(getGame(), goodsType);
        putMarketData(goodsType, data);
    }
    return data;
}