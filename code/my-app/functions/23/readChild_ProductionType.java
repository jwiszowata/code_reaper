public void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Specification spec = getSpecification();
    final String tag = xr.getLocalName();
    if (INPUT_TAG.equals(tag)) {
        GoodsType type = xr.getType(spec, GOODS_TYPE_TAG, GoodsType.class, (GoodsType) null);
        if (type == null) {
            logger.warning("Skipping input with null type: " + xr.getAttribute(GOODS_TYPE_TAG, (String) null));
        } else {
            addInput(type, xr.getAttribute(VALUE_TAG, -1));
        }
        xr.closeTag(INPUT_TAG);
    } else if (OUTPUT_TAG.equals(tag)) {
        GoodsType type = xr.getType(spec, GOODS_TYPE_TAG, GoodsType.class, (GoodsType) null);
        if (type == null) {
            logger.warning("Skipping output with null type: " + xr.getAttribute(GOODS_TYPE_TAG, (String) null));
        } else {
            addOutput(type, xr.getAttribute(VALUE_TAG, -1));
        }
        xr.closeTag(OUTPUT_TAG);
    } else {
        super.readChild(xr);
    }
}