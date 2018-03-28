protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.abstractType = xr.getAttribute(ABSTRACT_TAG, false);
}