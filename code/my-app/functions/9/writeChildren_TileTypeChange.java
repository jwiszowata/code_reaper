protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (this.production != null) {
        xw.writeStartElement(PRODUCTION_TAG);
        xw.writeAttribute(GOODS_TYPE_TAG, this.production.getType());
        xw.writeAttribute(VALUE_TAG, this.production.getAmount());
        xw.writeEndElement();
    }
}