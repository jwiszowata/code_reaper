protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TILE_TAG, getTile());
    if (type != null) {
        xw.writeAttribute(TYPE_TAG, getType());
    }
    if (name != null) {
        xw.writeAttribute(NAME_TAG, name);
    }
}