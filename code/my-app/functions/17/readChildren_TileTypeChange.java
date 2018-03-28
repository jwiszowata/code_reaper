protected void readChildren(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    if (xr.shouldClearContainers()) {
        this.production = null;
    }
    while (xr.moreTags()) {
        final String tag = xr.getLocalName();
        if (PRODUCTION_TAG.equals(tag)) {
            GoodsType type = xr.getType(spec, GOODS_TYPE_TAG, GoodsType.class, (GoodsType) null);
            int amount = xr.getAttribute(VALUE_TAG, 0);
            this.production = new AbstractGoods(type, amount);
            xr.closeTag(PRODUCTION_TAG);
        } else {
            throw new XMLStreamException("Bogus TileTypeChange tag: " + tag);
        }
    }
}