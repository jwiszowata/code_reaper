protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (REQUIRED_ABILITY_TAG.equals(tag)) {
        String id = xr.readId();
        addRequiredAbility(id, xr.getAttribute(VALUE_TAG, true));
        spec.addAbility(id);
        xr.closeTag(REQUIRED_ABILITY_TAG);
    } else if (REQUIRED_GOODS_TAG.equals(tag)) {
        GoodsType type = xr.getType(spec, ID_ATTRIBUTE_TAG, GoodsType.class, (GoodsType) null);
        int amount = xr.getAttribute(VALUE_TAG, 0);
        addRequiredGoods(new AbstractGoods(type, amount));
        xr.closeTag(REQUIRED_GOODS_TAG);
    } else if (Limit.TAG.equals(tag)) {
        Limit limit = new Limit(xr, spec);
        if (limit.getLeftHandSide().getType() == null) {
            limit.getLeftHandSide().setType(getId());
        }
        addLimit(limit);
    } else {
        super.readChild(xr);
    }
}