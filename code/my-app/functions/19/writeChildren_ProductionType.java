protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (inputs != null) {
        for (AbstractGoods input : inputs) {
            xw.writeStartElement(INPUT_TAG);
            xw.writeAttribute(GOODS_TYPE_TAG, input.getType());
            xw.writeAttribute(VALUE_TAG, input.getAmount());
            xw.writeEndElement();
        }
    }
    if (outputs != null) {
        for (AbstractGoods output : outputs) {
            xw.writeStartElement(OUTPUT_TAG);
            xw.writeAttribute(GOODS_TYPE_TAG, output.getType());
            xw.writeAttribute(VALUE_TAG, output.getAmount());
            xw.writeEndElement();
        }
    }
}