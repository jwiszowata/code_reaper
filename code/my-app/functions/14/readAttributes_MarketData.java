protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    goodsType = xr.getType(spec, GOODS_TYPE_TAG, GoodsType.class, (GoodsType) null);
    amountInMarket = xr.getAttribute(AMOUNT_TAG, 0);
    initialPrice = xr.getAttribute(INITIAL_PRICE_TAG, -1);
    arrears = xr.getAttribute(ARREARS_TAG, 0);
    sales = xr.getAttribute(SALES_TAG, 0);
    incomeBeforeTaxes = xr.getAttribute(INCOME_BEFORE_TAXES_TAG, 0);
    incomeAfterTaxes = xr.getAttribute(INCOME_AFTER_TAXES_TAG, 0);
    traded = xr.getAttribute(TRADED_TAG, sales != 0);
    update();
    oldPrice = costToBuy;
}