protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (requiredAbilities != null) {
        for (Map.Entry<String, Boolean> entry : requiredAbilities.entrySet()) {
            xw.writeStartElement(REQUIRED_ABILITY_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, entry.getKey());
            xw.writeAttribute(VALUE_TAG, entry.getValue());
            xw.writeEndElement();
        }
    }
    for (AbstractGoods goods : getRequiredGoodsList()) {
        xw.writeStartElement(REQUIRED_GOODS_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, goods.getType());
        xw.writeAttribute(VALUE_TAG, goods.getAmount());
        xw.writeEndElement();
    }
    for (Limit limit : getLimits()) limit.toXML(xw);
}