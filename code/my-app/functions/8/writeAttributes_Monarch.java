protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(PLAYER_TAG, this.player);
    if (xw.validFor(this.player)) {
        xw.writeAttribute(SUPPORT_SEA_TAG, supportSea);
        xw.writeAttribute(DISPLEASURE_TAG, displeasure);
    }
}