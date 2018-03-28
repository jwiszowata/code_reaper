protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        limits = null;
    }
    super.readChildren(xr);
}