public ChangeSet serverHandler(FreeColServer freeColServer, @SuppressWarnings("unused") ServerPlayer serverPlayer) {
    return ChangeSet.simpleChange((ServerPlayer) null, new GameStateMessage(freeColServer.getServerState()));
}