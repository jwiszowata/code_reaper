protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    if (xr.shouldClearContainers()) {
        startingUnitMap.clear();
    }
    final Specification spec = getSpecification();
    EuropeanNationType parent = xr.getType(spec, EXTENDS_TAG, EuropeanNationType.class, this);
    if (parent != this) {
        forEachMapEntry(parent.startingUnitMap, e -> startingUnitMap.put(e.getKey(), new HashMap<>(e.getValue())));
    }
    super.readChildren(xr);
}