public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String colonyId = getStringAttribute(COLONY_TAG);
    final String unitId = getStringAttribute(UNIT_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Colony colony;
    try {
        colony = serverPlayer.getOurFreeColGameObject(colonyId, Colony.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().joinColony(serverPlayer, unit, colony);
}