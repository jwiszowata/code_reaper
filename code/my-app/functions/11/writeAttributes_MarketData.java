protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(GOODS_TYPE_TAG, goodsType);
    xw.writeAttribute(AMOUNT_TAG, amountInMarket);
    xw.writeAttribute(INITIAL_PRICE_TAG, initialPrice);
    xw.writeAttribute(ARREARS_TAG, arrears);
    xw.writeAttribute(SALES_TAG, sales);
    xw.writeAttribute(INCOME_AFTER_TAXES_TAG, incomeAfterTaxes);
    xw.writeAttribute(INCOME_BEFORE_TAXES_TAG, incomeBeforeTaxes);
    xw.writeAttribute(TRADED_TAG, traded);
}