protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    gold = xr.getAttribute(GOLD_TAG, UNDEFINED);
}