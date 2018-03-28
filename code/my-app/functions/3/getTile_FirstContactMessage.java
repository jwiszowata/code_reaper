public Tile getTile(Game game) {
    return game.getFreeColGameObject(getStringAttribute(TILE_TAG), Tile.class);
}