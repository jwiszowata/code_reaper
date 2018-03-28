public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    Unit winner;
    try {
        winner = getUnit(game);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().lootCargo(serverPlayer, winner, this.loserId, goods);
}