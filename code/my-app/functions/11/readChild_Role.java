protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (ROLE_CHANGE_TAG.equals(tag)) {
        String from = xr.getAttribute(FROM_TAG, (String) null);
        String capture = xr.getAttribute(CAPTURE_TAG, (String) null);
        addRoleChange(from, capture);
        xr.closeTag(ROLE_CHANGE_TAG);
    } else {
        super.readChild(xr);
    }
}