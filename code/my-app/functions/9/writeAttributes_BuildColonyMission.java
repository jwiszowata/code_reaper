protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (target != null) {
        xw.writeAttribute(TARGET_TAG, target.getId());
        if (colonyValue > 0) {
            xw.writeAttribute(VALUE_TAG, colonyValue);
        }
    }
}