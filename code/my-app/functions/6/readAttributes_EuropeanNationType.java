protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    EuropeanNationType parent = xr.getType(spec, EXTENDS_TAG, EuropeanNationType.class, this);
    ref = xr.getAttribute(REF_TAG, parent.ref);
}