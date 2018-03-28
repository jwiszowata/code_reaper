protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    value = xr.getAttribute(VALUE_TAG, true);
}