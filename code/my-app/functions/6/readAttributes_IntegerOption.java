protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    maximumValue = xr.getAttribute(MAXIMUM_VALUE_TAG, Integer.MAX_VALUE);
    minimumValue = xr.getAttribute(MINIMUM_VALUE_TAG, Integer.MIN_VALUE);
    this.value = limitValue(this.value);
}