protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (CARGO_TAG.equals(tag)) {
        cargo.add(xr.getType(spec, ID_ATTRIBUTE_TAG, GoodsType.class, (GoodsType) null));
        xr.closeTag(CARGO_TAG);
    } else {
        super.readChild(xr);
    }
}