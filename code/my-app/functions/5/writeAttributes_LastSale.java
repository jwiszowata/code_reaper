protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(WHEN_TAG, when.getNumber());
    xw.writeAttribute(PRICE_TAG, price);
}