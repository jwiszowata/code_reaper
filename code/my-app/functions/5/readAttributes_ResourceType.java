protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    maxValue = xr.getAttribute(MAXIMUM_VALUE_TAG, -1);
    minValue = xr.getAttribute(MINIMUM_VALUE_TAG, -1);
}