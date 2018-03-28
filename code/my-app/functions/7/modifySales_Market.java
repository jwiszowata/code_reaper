public void modifySales(GoodsType goodsType, int amount) {
    if (amount != 0) {
        MarketData data = requireMarketData(goodsType);
        data.setSales(data.getSales() + amount);
        data.setTraded(true);
    }
}