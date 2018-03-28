protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(EDITABLE_TAG, editable);
    xw.writeAttribute(VISIBLE_TAG, visible);
}