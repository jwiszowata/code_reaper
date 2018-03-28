public Tile getDefenderTile(Game game) {
    return game.getFreeColGameObject(getStringAttribute(DEFENDER_TILE_TAG), Tile.class);
}