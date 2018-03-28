protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    featureContainer.clear();
    super.readChildren(xr);
    addFeatures(type);
}