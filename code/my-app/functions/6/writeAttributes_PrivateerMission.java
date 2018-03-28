protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    if (target != null) {
        xw.writeAttribute(TARGET_TAG, target.getId());
    }
}