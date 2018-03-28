protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        events = null;
        units = null;
    }
    super.readChildren(xr);
}