public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String directionString = getStringAttribute(DIRECTION_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Tile tile;
    try {
        tile = unit.getNeighbourTile(directionString);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    IndianSettlement is = tile.getIndianSettlement();
    if (is == null) {
        return serverPlayer.clientError("There is no native settlement at: " + tile.getId());
    }
    MoveType type = unit.getSimpleMoveType(is.getTile());
    if (type != MoveType.ENTER_INDIAN_SETTLEMENT_WITH_FREE_COLONIST) {
        return serverPlayer.clientError("Unable to enter " + is.getName() + ": " + type.whyIllegal());
    }
    return freeColServer.getInGameController().learnFromIndianSettlement(serverPlayer, unit, is);
}