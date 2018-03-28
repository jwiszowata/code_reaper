protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.collected = xr.getAttribute(COLLECTED_TAG, false);
    this.colony = xr.getAttribute(getGame(), COLONY_TAG, Colony.class, (Colony) null);
}