protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    setValue(xr.getAttribute(VALUE_TAG, -1));
}