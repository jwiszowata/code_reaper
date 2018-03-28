protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (LostCityRumour.TAG.equals(tag)) {
        LostCityRumour lcr = xr.readFreeColObject(game, LostCityRumour.class);
        if (lcr != null) {
            lcr.setTile(tile);
            addTileItem(lcr);
        }
    } else if (Resource.TAG.equals(tag)) {
        addTileItem(xr.readFreeColObject(game, Resource.class));
    } else if (TileImprovement.TAG.equals(tag) || OLD_TILE_IMPROVEMENT_TAG.equals(tag)) {
        addTileItem(xr.readFreeColObject(game, TileImprovement.class));
    } else {
        super.readChild(xr);
    }
}