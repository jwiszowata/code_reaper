public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    Colony colony;
    try {
        colony = serverPlayer.getOurFreeColGameObject(this.colonyId, Colony.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().setGoodsLevels(serverPlayer, colony, this.data);
}