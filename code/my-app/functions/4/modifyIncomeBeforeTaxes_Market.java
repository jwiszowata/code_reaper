public void modifyIncomeBeforeTaxes(GoodsType goodsType, int amount) {
    MarketData data = requireMarketData(goodsType);
    data.setIncomeBeforeTaxes(data.getIncomeBeforeTaxes() + amount);
}