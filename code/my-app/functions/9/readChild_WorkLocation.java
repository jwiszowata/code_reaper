public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (ProductionType.TAG.equals(tag)) {
        productionType = new ProductionType(xr, spec);
    } else {
        super.readChild(xr);
    }
}