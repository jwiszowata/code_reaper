protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    final Specification spec = getSpecification();
    if (defaultRole != null && defaultRole != spec.getDefaultRole()) {
        xw.writeStartElement(DEFAULT_ROLE_TAG);
        xw.writeAttribute(ID_ATTRIBUTE_TAG, defaultRole);
        xw.writeEndElement();
    }
    if (consumption != null) {
        for (GoodsType goodsType : consumption.keySet()) {
            xw.writeStartElement(CONSUMES_TAG);
            xw.writeAttribute(ID_ATTRIBUTE_TAG, goodsType);
            xw.writeAttribute(VALUE_TAG, consumption.getCount(goodsType));
            xw.writeEndElement();
        }
    }
}