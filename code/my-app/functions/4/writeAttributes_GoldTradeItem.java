protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(GOLD_TAG, gold);
}