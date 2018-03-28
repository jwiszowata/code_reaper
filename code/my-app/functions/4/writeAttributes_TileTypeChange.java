protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    xw.writeAttribute(FROM_TAG, this.from);
    xw.writeAttribute(TO_TAG, this.to);
}