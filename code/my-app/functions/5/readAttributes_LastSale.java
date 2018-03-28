public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    when = new Turn(xr.getAttribute(WHEN_TAG, 0));
    price = xr.getAttribute(PRICE_TAG, 0);
}