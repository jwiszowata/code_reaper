public Player getOtherPlayer(Game game) {
    return game.getFreeColGameObject(getStringAttribute(OTHER_TAG), Player.class);
}