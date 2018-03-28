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
    LostCityRumour rumour = tile.getLostCityRumour();
    if (rumour == null || rumour.getType() != LostCityRumour.RumourType.MOUNDS) {
        return serverPlayer.clientError("No mounds rumour on tile: " + tile.getId());
    }
    return freeColServer.getInGameController().declineMounds(serverPlayer, tile);
}