public Tile getBestEntryTile(Tile tile) {
    return getGame().getMap().getBestEntryTile(this, tile, null, null);
}