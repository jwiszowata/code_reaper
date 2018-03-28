public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    editable = xr.getAttribute(EDITABLE_TAG, true);
    visible = xr.getAttribute(VISIBLE_TAG, true);
}