public void modifyIncomeAfterTaxes(GoodsType goodsType, int amount) {
    MarketData data = requireMarketData(goodsType);
    data.setIncomeAfterTaxes(data.getIncomeAfterTaxes() + amount);
}