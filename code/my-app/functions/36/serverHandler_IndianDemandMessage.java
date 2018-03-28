public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    final String unitId = getStringAttribute(UNIT_TAG);
    final String colonyId = getStringAttribute(COLONY_TAG);
    final Boolean result = getResult();
    Unit unit;
    Colony colony;
    try {
        if (serverPlayer.isIndian()) {
            unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
            if (unit.getMovesLeft() <= 0) {
                return serverPlayer.clientError("Unit has no moves left: " + unitId);
            }
            colony = unit.getAdjacentSettlement(colonyId, Colony.class);
            if (result != null) {
                return serverPlayer.clientError("Result in demand: " + serverPlayer.getId() + " " + result);
            }
        } else {
            unit = game.getFreeColGameObject(unitId, Unit.class);
            if (unit == null) {
                return serverPlayer.clientError("Not a unit: " + unitId);
            }
            colony = serverPlayer.getOurFreeColGameObject(colonyId, Colony.class);
            if (result == null) {
                return serverPlayer.clientError("No result in demand response: " + serverPlayer.getId());
            }
        }
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    int amount = getAmount();
    if (amount <= 0) {
        return serverPlayer.clientError("Bad amount: " + amount);
    }
    return freeColServer.getInGameController().indianDemand(serverPlayer, unit, colony, getType(game), amount, result);
}