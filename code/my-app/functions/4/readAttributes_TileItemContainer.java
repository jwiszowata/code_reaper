protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    tile = xr.findFreeColGameObject(getGame(), TILE_TAG, Tile.class, (Tile) null, true);
}