public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    return freeColServer.getInGameController().monarchAction(serverPlayer, getAction(), getResult());
}