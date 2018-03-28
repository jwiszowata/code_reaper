protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.ownerChange = xr.getAttribute(OWNER_CHANGE_TAG, false);
}