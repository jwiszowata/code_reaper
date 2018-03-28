protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    final Game game = getGame();
    x = xr.getAttribute(X_TAG, 0);
    y = xr.getAttribute(Y_TAG, 0);
    type = xr.getType(spec, TYPE_TAG, TileType.class, (TileType) null);
    if (type == null) {
        style = 0;
        highSeasCount = -1;
        owner = null;
        region = null;
        moveToEurope = null;
        contiguity = -1;
        return;
    }
    style = xr.getAttribute(STYLE_TAG, 0);
    String str = xr.getAttribute(CONNECTED_TAG, (String) null);
    if (str == null || str.isEmpty()) {
        highSeasCount = -1;
    } else {
        try {
            highSeasCount = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            highSeasCount = -1;
        }
    }
    owner = xr.findFreeColGameObject(game, OWNER_TAG, Player.class, (Player) null, false);
    region = xr.findFreeColGameObject(game, REGION_TAG, Region.class, (Region) null, false);
    moveToEurope = (xr.hasAttribute(MOVE_TO_EUROPE_TAG)) ? xr.getAttribute(MOVE_TO_EUROPE_TAG, false) : null;
    contiguity = xr.getAttribute(CONTIGUITY_TAG, -1);
    Location loc = xr.getLocationAttribute(game, OWNING_SETTLEMENT_TAG, true);
    owningSettlement = (loc instanceof Settlement) ? (Settlement) loc : null;
}