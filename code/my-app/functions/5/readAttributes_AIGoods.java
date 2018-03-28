protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Game game = getAIMain().getGame();
    destination = xr.getLocationAttribute(game, DESTINATION_TAG, false);
}