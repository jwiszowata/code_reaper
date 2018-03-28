protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(VALUE_TAG, value);
    if (maximumValue < Integer.MAX_VALUE) {
        xw.writeAttribute(MAXIMUM_VALUE_TAG, maximumValue);
    }
    if (minimumValue > Integer.MIN_VALUE) {
        xw.writeAttribute(MINIMUM_VALUE_TAG, minimumValue);
    }
}