protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    super.readAttributes(xr);
    this.type = xr.getType(spec, TYPE_TAG, GoodsType.class, (GoodsType) null);
    if (this.type == null) {
        throw new XMLStreamException("Null goods type.");
    } else {
        setId(this.type.getId());
    }
    this.amount = xr.getAttribute(AMOUNT_TAG, 0);
    this.location = xr.getLocationAttribute(game, LOCATION_TAG, true);
}