protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(PRICE_TAG, this.price);
    xw.writeAttribute(HAGGLE_COUNT_TAG, this.haggleCount);
}