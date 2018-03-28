protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    location = xr.getLocationAttribute(getGame(), LOCATION_TAG, true);
}