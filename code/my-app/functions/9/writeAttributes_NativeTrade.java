protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(BUY_TAG, this.buy);
    xw.writeAttribute(COUNT_TAG, this.count);
    xw.writeAttribute(GIFT_TAG, this.gift);
    xw.writeAttribute(SELL_TAG, this.sell);
    xw.writeAttribute(SETTLEMENT_TAG, this.is);
    xw.writeAttribute(UNIT_TAG, this.unit);
}