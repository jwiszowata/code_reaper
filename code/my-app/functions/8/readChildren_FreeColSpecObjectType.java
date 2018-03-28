protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        if (this.featureContainer != null)
            this.featureContainer.clear();
        setScopes(null);
    }
    super.readChildren(xr);
}