protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    destination = xr.getLocationAttribute(getGame(), DESTINATION_TAG, false);
    blockedCount = xr.getAttribute(BLOCKED_COUNT_TAG, 0);
}