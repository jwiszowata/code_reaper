public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!unit.canCarryTreasure()) {
        return serverPlayer.clientError("Can not cash in unit " + unitId + ", can not carry treasure.");
    } else if (!unit.canCashInTreasureTrain()) {
        return serverPlayer.clientError("Can not cash in unit " + unitId + ", unsuitable location.");
    }
    return freeColServer.getInGameController().cashInTreasureTrain(serverPlayer, unit);
}