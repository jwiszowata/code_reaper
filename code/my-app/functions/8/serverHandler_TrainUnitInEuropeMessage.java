public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String typeId = getStringAttribute(UNIT_TYPE_TAG);
    UnitType type = freeColServer.getSpecification().getUnitType(typeId);
    if (type == null) {
        return serverPlayer.clientError("Not a unit type: " + typeId);
    }
    return freeColServer.getInGameController().trainUnitInEurope(serverPlayer, type);
}