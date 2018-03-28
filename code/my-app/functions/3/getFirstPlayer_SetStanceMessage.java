public Player getFirstPlayer(Game game) {
    return game.getFreeColGameObject(getStringAttribute(FIRST_TAG), Player.class);
}