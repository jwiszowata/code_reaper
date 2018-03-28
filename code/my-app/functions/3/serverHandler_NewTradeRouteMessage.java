public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    return freeColServer.getInGameController().newTradeRoute(serverPlayer);
}