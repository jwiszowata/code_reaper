public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    sourceId = xr.getAttribute(SOURCE_TAG, (String) null);
    displayId = xr.getAttribute(DISPLAY_TAG, (String) null);
    messageType = xr.getAttribute(MESSAGE_TYPE_TAG, MessageType.class, MessageType.DEFAULT);
    beenDisplayed = xr.getAttribute(HAS_BEEN_DISPLAYED_TAG, false);
}