protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    target = xr.getLocationAttribute(getGame(), TARGET_TAG, false);
}