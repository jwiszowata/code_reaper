protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (Limit.TAG.equals(tag)) {
        Limit limit = new Limit(xr, spec);
        if ("model.limit.independence.colonies".equals(limit.getId())) {
            limit.setId("model.limit.independence.coastalColonies");
            limit.getLeftHandSide().setMethodName("isConnectedPort");
        }
        addLimit(limit);
    } else {
        super.readChild(xr);
    }
}