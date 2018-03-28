protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.victim = xr.findFreeColGameObject(getGame(), VICTIM_TAG, Player.class, (Player) null, true);
}