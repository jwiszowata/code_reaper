protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(GOODS_TYPE_TAG, goodsType);
    xw.writeAttribute(AMOUNT_REQUESTED_TAG, amountRequested);
}