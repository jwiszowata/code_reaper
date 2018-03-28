public Tile getNewTile(Game game) {
    return game.getFreeColGameObject(getStringAttribute(NEW_TILE_TAG), Tile.class);
}