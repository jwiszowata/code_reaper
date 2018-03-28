public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    maximumNumber = xr.getAttribute(MAXIMUM_NUMBER_TAG, 1);
}