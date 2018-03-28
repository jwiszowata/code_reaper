public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    if (serverPlayer == null || !serverPlayer.isAdmin()) {
        return serverPlayer.clientError("Not an admin: " + serverPlayer);
    }
    final Specification spec = freeColServer.getGame().getSpecification();
    if (this.options == null) {
        return serverPlayer.clientError("No map options to merge");
    }
    if (!spec.mergeMapGeneratorOptions(this.options, "server")) {
        return serverPlayer.clientError("Map option merge failed");
    }
    UpdateMapGeneratorOptionsMessage message = new UpdateMapGeneratorOptionsMessage(spec.getMapGeneratorOptions());
    freeColServer.sendToAll(message, serverPlayer);
    return null;
}