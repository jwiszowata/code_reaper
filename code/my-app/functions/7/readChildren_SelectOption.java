protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    String value = xr.getAttribute(VALUE_TAG, (String) null);
    String defaultValue = xr.getAttribute(DEFAULT_VALUE_TAG, (String) null);
    clearItemValues();
    super.readChildren(xr);
    setValue(value, defaultValue);
}