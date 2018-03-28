public Player getSecondPlayer(Game game) {
    return game.getFreeColGameObject(getStringAttribute(SECOND_TAG), Player.class);
}