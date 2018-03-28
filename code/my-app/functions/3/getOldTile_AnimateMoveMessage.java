public Tile getOldTile(Game game) {
    return game.getFreeColGameObject(getStringAttribute(OLD_TILE_TAG), Tile.class);
}