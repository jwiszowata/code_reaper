public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    return freeColServer.getInGameController().updateTradeRoute(serverPlayer, this.tradeRoute);
}