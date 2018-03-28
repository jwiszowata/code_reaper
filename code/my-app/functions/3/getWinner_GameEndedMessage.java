public Player getWinner(Game game) {
    return game.getFreeColGameObject(getStringAttribute(WINNER_TAG), Player.class);
}