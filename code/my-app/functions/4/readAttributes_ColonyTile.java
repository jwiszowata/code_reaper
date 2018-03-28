protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    workTile = xr.makeFreeColObject(getGame(), WORK_TILE_TAG, Tile.class, true);
}