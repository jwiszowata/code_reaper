protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (SETTLEMENT_TAG.equals(tag)) {
        addSettlementType(new SettlementType(xr, spec));
    } else {
        super.readChild(xr);
    }
}