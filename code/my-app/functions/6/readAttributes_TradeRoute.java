protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    this.name = xr.getAttribute(NAME_TAG, (String) null);
    this.owner = xr.findFreeColGameObject(getGame(), OWNER_TAG, Player.class, (Player) null, true);
    this.silent = xr.getAttribute(SILENT_TAG, false);
}