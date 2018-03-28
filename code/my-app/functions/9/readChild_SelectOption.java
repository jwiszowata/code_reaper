protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (getXMLItemElementTagName().equals(tag)) {
        addItemValue(xr.getAttribute(VALUE_TAG, INFINITY), xr.getAttribute(LABEL_TAG, (String) null));
        xr.closeTag(tag);
    } else {
        super.readChild(xr);
    }
}