protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (Region.TAG.equals(tag)) {
        addRegion(xr.readFreeColObject(game, Region.class));
    } else if (Tile.TAG.equals(tag)) {
        Tile t = xr.readFreeColObject(game, Tile.class);
        setTile(t, t.getX(), t.getY());
        if (t.getHighSeasCount() == Tile.FLAG_RECALCULATE) {
            fixupHighSeas = true;
        }
    } else {
        super.readChild(xr);
    }
}