protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TILE_TAG, getTile());
    xw.writeAttribute(TYPE_TAG, getType());
    xw.writeAttribute(TURNS_TAG, turnsToComplete);
    xw.writeAttribute(MAGNITUDE_TAG, magnitude);
    if (style != null)
        xw.writeAttribute(STYLE_TAG, style);
    if (virtual)
        xw.writeAttribute(VIRTUAL_TAG, virtual);
}