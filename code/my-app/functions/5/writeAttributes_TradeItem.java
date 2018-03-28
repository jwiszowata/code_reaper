protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(SOURCE_TAG, this.source);
    xw.writeAttribute(DESTINATION_TAG, this.destination);
}