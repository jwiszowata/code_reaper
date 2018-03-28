protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.price = xr.getAttribute(PRICE_TAG, PRICE_INVALID);
    this.haggleCount = xr.getAttribute(HAGGLE_COUNT_TAG, -1);
}