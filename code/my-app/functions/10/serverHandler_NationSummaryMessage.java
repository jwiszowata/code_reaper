public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    Player player = getPlayer(game);
    if (player == null) {
        return serverPlayer.clientError("Not a player: " + this.playerId);
    } else if (player.isIndian() && !serverPlayer.hasContacted(player)) {
        return null;
    }
    return freeColServer.getInGameController().nationSummary(serverPlayer, player);
}