protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (this.colony != null) {
        xw.writeAttribute(COLONY_TAG, this.colony.getId());
    }
    xw.writeAttribute(DEMANDED_TAG, this.demanded);
    xw.writeAttribute(SUCCEEDED_TAG, this.succeeded);
}