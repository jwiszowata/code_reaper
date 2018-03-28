protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    colony = xr.findFreeColGameObject(getGame(), COLONY_TAG, Colony.class, (Colony) null, true);
}