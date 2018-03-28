protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        settlementTypes = null;
    }
    final Specification spec = getSpecification();
    NationType parent = xr.getType(spec, EXTENDS_TAG, NationType.class, this);
    if (parent != this) {
        if (parent.settlementTypes != null) {
            addSettlementTypes(parent.settlementTypes);
        }
        addFeatures(parent);
        if (parent.isAbstractType()) {
            getFeatureContainer().replaceSource(parent, this);
        }
    }
    super.readChildren(xr);
}