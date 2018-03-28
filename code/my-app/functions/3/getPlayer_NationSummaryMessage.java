public Player getPlayer(Game game) {
    return game.getFreeColGameObject(playerId, Player.class);
}