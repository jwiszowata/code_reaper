public ChangeSet serverHandler(FreeColServer server, ServerPlayer serverPlayer) {
    setStringAttribute(SENDER_TAG, serverPlayer.getId());
    server.getInGameController().chat(serverPlayer, getMessage(), isPrivate());
    return null;
}