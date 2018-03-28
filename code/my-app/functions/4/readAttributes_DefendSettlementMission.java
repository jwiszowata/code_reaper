protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    target = xr.getAttribute(getGame(), SETTLEMENT_TAG, Settlement.class, (Settlement) null);
}