protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.source = xr.getAttribute(getGame(), SOURCE_TAG, Player.class, (Player) null);
    this.destination = xr.getAttribute(getGame(), DESTINATION_TAG, Player.class, (Player) null);
}