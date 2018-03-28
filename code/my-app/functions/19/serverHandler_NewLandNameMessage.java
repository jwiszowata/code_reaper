public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    Unit unit;
    try {
        unit = getUnit(serverPlayer);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Tile tile = unit.getTile();
    if (tile == null) {
        return serverPlayer.clientError("Unit is not on the map: " + unit.getId());
    } else if (!tile.isLand()) {
        return serverPlayer.clientError("Unit is not in the new world: " + unit.getId());
    }
    String newLandName = getNewLandName();
    if (newLandName == null || newLandName.isEmpty()) {
        return serverPlayer.clientError("Empty new land name");
    }
    return freeColServer.getInGameController().setNewLandName(serverPlayer, unit, newLandName);
}