public void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    name = xr.getAttribute(NAME_TAG, (String) null);
    if (xr.hasAttribute(NAME_KEY_TAG)) {
        key = xr.getAttribute(NAME_KEY_TAG, (String) null);
        key = fixRegionKey(key);
    } else
        key = xr.getAttribute(KEY_TAG, (String) null);
    type = xr.getAttribute(TYPE_TAG, RegionType.class, (RegionType) null);
    claimable = xr.getAttribute(CLAIMABLE_TAG, false);
    discoverable = xr.getAttribute(DISCOVERABLE_TAG, false);
    scoreValue = xr.getAttribute(SCORE_VALUE_TAG, 0);
    int turn = xr.getAttribute(DISCOVERED_IN_TAG, UNDEFINED);
    discoveredIn = (turn == UNDEFINED) ? null : new Turn(turn);
    discoveredBy = xr.findFreeColGameObject(getGame(), DISCOVERED_BY_TAG, Player.class, (Player) null, false);
    parent = xr.makeFreeColObject(getGame(), PARENT_TAG, Region.class, false);
}