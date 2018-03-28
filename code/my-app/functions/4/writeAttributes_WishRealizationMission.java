protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(WISH_TAG, wish);
}