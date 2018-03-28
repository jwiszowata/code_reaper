protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(TYPE_TAG, type);
    xw.writeAttribute(TARGET_TAG, target);
    if (pioneer != null && pioneer.checkIntegrity(false) > 0) {
        xw.writeAttribute(PIONEER_TAG, pioneer);
    }
}