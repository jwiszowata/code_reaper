protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        allowedWorkers = null;
        tileTypeChanges = null;
        disasters = null;
    }
    super.readChildren(xr);
}