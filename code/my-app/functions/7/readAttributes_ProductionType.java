public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    unattended = xr.getAttribute(UNATTENDED_TAG, false);
    productionLevel = xr.getAttribute(PRODUCTION_LEVEL_TAG, (String) null);
    if (productionLevel == null) {
        productionLevel = xr.getAttribute(OLD_PRODUCTION_LEVEL_TAG, (String) null);
    }
}