protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    localizedLabels = xr.getAttribute(LOCALIZED_LABELS_TAG, true);
}