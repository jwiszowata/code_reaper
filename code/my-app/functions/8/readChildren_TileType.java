protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        disasters = null;
        resourceTypes = null;
        productionTypes.clear();
    }
    super.readChildren(xr);
}