protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    xw.writeAttribute(EXPORTED_TAG, exported);
    xw.writeAttribute(HIGH_LEVEL_TAG, highLevel);
    xw.writeAttribute(LOW_LEVEL_TAG, lowLevel);
    xw.writeAttribute(IMPORT_LEVEL_TAG, importLevel);
    xw.writeAttribute(EXPORT_LEVEL_TAG, exportLevel);
}