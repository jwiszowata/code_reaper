public int getIncomeAfterTaxes(GoodsType goodsType) {
    MarketData data = getMarketData(goodsType);
    return (data == null) ? 0 : data.getIncomeAfterTaxes();
}