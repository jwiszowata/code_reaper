protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    owner = xr.findFreeColGameObject(getGame(), OWNER_TAG, Player.class, (Player) null, true);
}