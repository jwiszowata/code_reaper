public Player getPlayer(Game game) {
    return game.getFreeColGameObject(getStringAttribute(PLAYER_TAG), Player.class);
}