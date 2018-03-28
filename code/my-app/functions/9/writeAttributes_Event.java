protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (value != null) {
        xw.writeAttribute(VALUE_TAG, value);
    }
    if (scoreValue != 0) {
        xw.writeAttribute(SCORE_VALUE_TAG, scoreValue);
    }
}