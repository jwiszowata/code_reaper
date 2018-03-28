public boolean hasPriceChanged(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    return data != null && data.getOldPrice() != 0 && data.getOldPrice() != data.getCostToBuy();
}