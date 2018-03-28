protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(COLLECTED_TAG, this.collected);
    if (this.colony != null) {
        xw.writeAttribute(COLONY_TAG, this.colony.getId());
    }
}