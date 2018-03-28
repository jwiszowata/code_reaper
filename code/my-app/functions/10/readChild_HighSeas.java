protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (DESTINATION_TAG.equals(tag)) {
        addDestination(xr.getLocationAttribute(game, ID_ATTRIBUTE_TAG, true));
        xr.closeTag(DESTINATION_TAG);
    } else {
        super.readChild(xr);
    }
}