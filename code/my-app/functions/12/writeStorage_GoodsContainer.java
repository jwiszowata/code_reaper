private void writeStorage(FreeColXMLWriter xw, String tag, Map<GoodsType, Integer> storage) throws XMLStreamException {
    if (storage.isEmpty())
        return;
    xw.writeStartElement(tag);
    for (GoodsType goodsType : sort(storage.keySet())) {
        xw.writeStartElement(Goods.TAG);
        xw.writeAttribute(TYPE_TAG, goodsType);
        xw.writeAttribute(AMOUNT_TAG, storage.get(goodsType));
        xw.writeEndElement();
    }
    xw.writeEndElement();
}