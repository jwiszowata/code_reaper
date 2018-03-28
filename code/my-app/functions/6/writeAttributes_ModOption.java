protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (value != null) {
        xw.writeAttribute(VALUE_TAG, value.getId());
    }
}