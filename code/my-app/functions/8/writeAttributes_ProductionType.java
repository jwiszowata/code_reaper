protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    if (unattended) {
        xw.writeAttribute(UNATTENDED_TAG, unattended);
    }
    if (productionLevel != null) {
        xw.writeAttribute(PRODUCTION_LEVEL_TAG, productionLevel);
    }
}