protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (CHOICE_TAG.equals(tag)) {
        choices.add(xr.getAttribute(VALUE_TAG, (String) null));
        xr.closeTag(CHOICE_TAG);
    } else {
        super.readChild(xr);
    }
}