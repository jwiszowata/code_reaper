protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    colony = xr.getAttribute(getGame(), COLONY_TAG, Colony.class, (Colony) null);
}