public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!unit.hasTile()) {
        return serverPlayer.clientError("Unit is not on the map: " + unitId);
    } else if (unit.getColony() == null) {
        return serverPlayer.clientError("Unit is not in a colony: " + unitId);
    }
    return freeColServer.getInGameController().putOutsideColony(serverPlayer, unit);
}