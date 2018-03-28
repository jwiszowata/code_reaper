public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final String unitId = getStringAttribute(UNIT_TAG);
    final String destinationId = getStringAttribute(DESTINATION_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Location destination = (destinationId == null) ? null : game.findFreeColLocation(destinationId);
    return freeColServer.getInGameController().setDestination(serverPlayer, unit, destination);
}