protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    String defaultValue = xr.getAttribute(DEFAULT_VALUE_TAG, (String) null);
    String value = xr.getAttribute(VALUE_TAG, (String) null);
    if (defaultValue == null && value == null) {
        if (!isNullValueOK()) {
            throw new XMLStreamException("invalid option " + getId() + ": no value nor default value found.");
        }
    } else {
        setValue(value, defaultValue);
    }
}