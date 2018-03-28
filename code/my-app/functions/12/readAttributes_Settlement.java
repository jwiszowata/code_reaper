protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Game game = getGame();
    name = xr.getAttribute(NAME_TAG, (String) null);
    Player oldOwner = owner;
    owner = xr.findFreeColGameObject(game, OWNER_TAG, Player.class, (Player) null, true);
    if (xr.shouldIntern())
        game.checkOwners(this, oldOwner);
    tile = xr.findFreeColGameObject(game, TILE_TAG, Tile.class, (Tile) null, true);
    String newType = xr.getAttribute(SETTLEMENT_TYPE_TAG, (String) null);
    type = owner.getNationType().getSettlementType(newType);
}