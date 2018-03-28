public Player getPlayer(Game game) {
    return game.getFreeColGameObject(getStringAttribute(SENDER_TAG), Player.class);
}