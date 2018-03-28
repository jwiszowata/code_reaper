protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        this.plunder = null;
        this.gifts = null;
    }
    super.readChildren(xr);
}