public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    if (serverPlayer != null) {
        boolean ready = getValue();
        serverPlayer.setReady(ready);
        freeColServer.sendToAll(new ReadyMessage(serverPlayer, ready), serverPlayer);
    } else {
        logger.warning("Ready from unknown connection.");
    }
    return null;
}