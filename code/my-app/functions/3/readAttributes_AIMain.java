protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    nextId = xr.getAttribute(NEXT_ID_TAG, -1);
}