protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (initialAmount > 0) {
        xw.writeStartElement(MARKET_TAG);
        xw.writeAttribute(INITIAL_AMOUNT_TAG, initialAmount);
        xw.writeAttribute(INITIAL_PRICE_TAG, initialPrice);
        xw.writeAttribute(PRICE_DIFFERENCE_TAG, priceDiff);
        xw.writeEndElement();
    }
}