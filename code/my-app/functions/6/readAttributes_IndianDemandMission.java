protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.colony = xr.getAttribute(getGame(), COLONY_TAG, Colony.class, (Colony) null);
    this.demanded = xr.getAttribute(DEMANDED_TAG, false);
    this.succeeded = xr.getAttribute(SUCCEEDED_TAG, false);
}