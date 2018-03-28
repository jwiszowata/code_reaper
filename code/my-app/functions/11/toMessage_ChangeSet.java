public AddPlayerMessage toMessage(ServerPlayer serverPlayer) {
    if (!isNotifiable(serverPlayer))
        return null;
    final Game game = serverPlayer.getGame();
    AddPlayerMessage message = new AddPlayerMessage();
    for (ServerPlayer sp : serverPlayers) {
        Player p = (serverPlayer.getId().equals(sp.getId())) ? sp : sp.copy(game, Player.class, serverPlayer);
        message.addPlayer(p);
    }
    return message;
}