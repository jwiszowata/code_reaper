public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = serverPlayer.getGame();
    final String unitId = getStringAttribute(UNIT_TAG);
    final String destinationId = getStringAttribute(DESTINATION_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Location destination = game.findFreeColLocation(destinationId);
    if (destination == null) {
        return serverPlayer.clientError("Not a location: " + destinationId);
    }
    return freeColServer.getInGameController().moveTo(serverPlayer, unit, destination);
}