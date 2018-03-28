protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(OWNER_TAG, owner);
    xw.writeAttribute(TILE_TAG, tile);
    xw.writeAttribute(SETTLEMENT_TYPE_TAG, getType());
}