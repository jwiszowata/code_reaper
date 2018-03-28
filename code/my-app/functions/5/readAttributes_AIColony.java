protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final AIMain aiMain = getAIMain();
    colony = xr.getAttribute(aiMain.getGame(), ID_ATTRIBUTE_TAG, Colony.class, (Colony) null);
}