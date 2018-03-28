public void update(GoodsType goodsType) {
    MarketData data = requireMarketData(goodsType);
    if (data != null)
        data.update();
}