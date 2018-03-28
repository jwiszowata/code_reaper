protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (maxValue > -1) {
        xw.writeAttribute(MAXIMUM_VALUE_TAG, maxValue);
        xw.writeAttribute(MINIMUM_VALUE_TAG, minValue);
    }
}