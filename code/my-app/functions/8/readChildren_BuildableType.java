protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        requiredAbilities = null;
        requiredGoods = null;
        limits = null;
    }
    super.readChildren(xr);
}