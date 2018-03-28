protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    tile = xr.findFreeColGameObject(getGame(), TILE_TAG, Tile.class, (Tile) null, false);
    type = xr.getAttribute(TYPE_TAG, RumourType.class, (RumourType) null);
    name = xr.getAttribute(NAME_TAG, (String) null);
}