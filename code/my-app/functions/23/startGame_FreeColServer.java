public void startGame() throws FreeColException {
    logger.info("Starting game.");
    final Game game = buildGame();
    switch(this.serverState) {
        case PRE_GAME:
            for (Player player : transform(game.getLivePlayers(), p -> !p.isAI())) {
                ServerPlayer serverPlayer = (ServerPlayer) player;
                serverPlayer.invalidateCanSeeTiles();
                ChangeSet cs = new ChangeSet();
                cs.add(See.only(serverPlayer), game);
                serverPlayer.send(cs);
            }
            break;
        case LOAD_GAME:
            break;
        default:
            logger.warning("Invalid startGame when server state = " + this.serverState);
            return;
    }
    changeServerState(ServerState.IN_GAME);
    sendToAll(TrivialMessage.START_GAME_MESSAGE, (ServerPlayer) null);
    updateMetaServer();
}