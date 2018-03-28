private void readStorage(FreeColXMLReader xr, Map<GoodsType, Integer> storage) throws XMLStreamException {
    final Specification spec = getGame().getSpecification();
    while (xr.moreTags()) {
        String tag = xr.getLocalName();
        if (Goods.TAG.equals(tag)) {
            GoodsType goodsType = xr.getType(spec, TYPE_TAG, GoodsType.class, (GoodsType) null);
            int amount = xr.getAttribute(AMOUNT_TAG, 0);
            storage.put(goodsType, amount);
        } else {
            throw new XMLStreamException("Bogus GoodsContainer tag: " + tag);
        }
        xr.closeTag(tag);
    }
}