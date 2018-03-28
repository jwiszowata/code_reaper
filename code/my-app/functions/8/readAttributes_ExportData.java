public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    exported = xr.getAttribute(EXPORTED_TAG, false);
    highLevel = xr.getAttribute(HIGH_LEVEL_TAG, HIGH_LEVEL_DEFAULT);
    lowLevel = xr.getAttribute(LOW_LEVEL_TAG, LOW_LEVEL_DEFAULT);
    importLevel = xr.getAttribute(IMPORT_LEVEL_TAG, -1);
    exportLevel = xr.getAttribute(EXPORT_LEVEL_TAG, EXPORT_LEVEL_DEFAULT);
}