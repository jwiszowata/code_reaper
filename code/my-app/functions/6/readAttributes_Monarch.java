protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    player = xr.findFreeColGameObject(getGame(), PLAYER_TAG, Player.class, (Player) null, true);
    supportSea = xr.getAttribute(SUPPORT_SEA_TAG, false);
    displeasure = xr.getAttribute(DISPLEASURE_TAG, false);
}