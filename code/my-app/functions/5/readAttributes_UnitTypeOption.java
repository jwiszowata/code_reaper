protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    selector = xr.getAttribute(GENERATE_TAG, TypeSelector.class, (TypeSelector) null);
    addNone = xr.getAttribute(ADD_NONE_TAG, false);
}