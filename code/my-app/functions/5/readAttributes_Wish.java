protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final AIMain aiMain = getAIMain();
    destination = xr.getLocationAttribute(aiMain.getGame(), DESTINATION_TAG, false);
}