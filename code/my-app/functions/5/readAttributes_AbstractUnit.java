protected final void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    roleId = xr.getAttribute(ROLE_TAG, Specification.DEFAULT_ROLE_ID);
    number = xr.getAttribute(NUMBER_TAG, 1);
}