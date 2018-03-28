public Tile getAttackerTile(Game game) {
    return game.getFreeColGameObject(getStringAttribute(ATTACKER_TILE_TAG), Tile.class);
}