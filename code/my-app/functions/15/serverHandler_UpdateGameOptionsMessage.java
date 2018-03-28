public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    if (serverPlayer == null || !serverPlayer.isAdmin()) {
        return serverPlayer.clientError("Not an admin: " + serverPlayer);
    }
    final Specification spec = freeColServer.getGame().getSpecification();
    if (this.options == null) {
        return serverPlayer.clientError("No game options to merge");
    }
    if (!spec.mergeGameOptions(this.options, "server")) {
        return serverPlayer.clientError("Game option merge failed");
    }
    UpdateGameOptionsMessage message = new UpdateGameOptionsMessage(spec.getGameOptions());
    freeColServer.sendToAll(message, serverPlayer);
    return null;
}