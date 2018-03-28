public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String colonyId = getStringAttribute(COLONY_TAG);
    Colony colony;
    try {
        colony = serverPlayer.getOurFreeColGameObject(colonyId, Colony.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().payForBuilding(serverPlayer, colony);
}