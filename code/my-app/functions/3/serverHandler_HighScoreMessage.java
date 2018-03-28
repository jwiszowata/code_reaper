public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    return freeColServer.getInGameController().getHighScores(serverPlayer, this.key);
}