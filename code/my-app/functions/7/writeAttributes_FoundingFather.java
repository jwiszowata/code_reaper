protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TYPE_TAG, type);
    for (int i = 0; i < weight.length; i++) {
        xw.writeAttribute(WEIGHT_TAG + (i + 1), weight[i]);
    }
}