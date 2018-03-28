protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (MARKET_TAG.equals(tag)) {
        initialAmount = xr.getAttribute(INITIAL_AMOUNT_TAG, 0);
        initialPrice = xr.getAttribute(INITIAL_PRICE_TAG, 1);
        priceDiff = xr.getAttribute(PRICE_DIFFERENCE_TAG, 1);
        xr.closeTag(MARKET_TAG);
    } else {
        super.readChild(xr);
    }
}