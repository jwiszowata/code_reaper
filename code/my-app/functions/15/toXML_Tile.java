public void toXML(FreeColXMLWriter xw, String tag) throws XMLStreamException {
    Player player = xw.getClientPlayer();
    Tile tile;
    if (player == null) {
        this.internalToXML(xw, tag);
    } else if ((tile = getCachedTile(player)) == null) {
        xw.writeStartElement(tag);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, getId());
        xw.writeAttribute(X_TAG, this.x);
        xw.writeAttribute(Y_TAG, this.y);
        xw.writeEndElement();
    } else {
        tile.internalToXML(xw, tag);
    }
}