protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (value != null) {
        xw.writeAttribute(VALUE_TAG, value);
    }
    if (selector != null) {
        xw.writeAttribute(GENERATE_TAG, selector);
    }
    if (addNone) {
        xw.writeAttribute(ADD_NONE_TAG, addNone);
    }
}