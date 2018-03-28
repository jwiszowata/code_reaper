protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(VICTIM_TAG, this.victim);
}