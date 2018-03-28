protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    index = xr.getAttribute(INDEX_TAG, 0);
}