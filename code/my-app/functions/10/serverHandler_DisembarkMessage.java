public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    ServerUnit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, ServerUnit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().disembarkUnit(serverPlayer, unit);
}