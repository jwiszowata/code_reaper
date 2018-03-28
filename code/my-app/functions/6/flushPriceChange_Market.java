public void flushPriceChange(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    if (data != null) {
        data.setOldPrice(data.getCostToBuy());
    }
}