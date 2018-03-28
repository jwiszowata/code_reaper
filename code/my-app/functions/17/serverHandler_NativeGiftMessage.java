public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String colonyId = getStringAttribute(COLONY_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Colony colony;
    try {
        colony = unit.getAdjacentSettlement(colonyId, Colony.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().nativeGift(serverPlayer, unit, colony);
}