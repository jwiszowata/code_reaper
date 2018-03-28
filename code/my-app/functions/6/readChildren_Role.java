protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        roleChanges = null;
    }
    super.readChildren(xr);
}