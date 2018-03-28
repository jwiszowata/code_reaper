public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    return serverPlayer.clientError("Invalid message type: " + getType());
}