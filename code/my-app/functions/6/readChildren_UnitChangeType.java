protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        this.changes.clear();
    }
    super.readChildren(xr);
}