protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (KEY_TAG.equals(tag)) {
        addKey(xr.getAttribute(VALUE_TAG, (String) null));
        xr.closeTag(KEY_TAG);
    } else if (StringTemplate.TAG.equals(tag)) {
        addReplacement(new StringTemplate(xr));
    } else {
        super.readChild(xr);
    }
}