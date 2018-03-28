public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final Specification spec = game.getSpecification();
    Colony colony;
    try {
        colony = getColony(serverPlayer);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    List<BuildableType> buildQueue;
    try {
        buildQueue = getQueue(spec);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().setBuildQueue(serverPlayer, colony, buildQueue);
}