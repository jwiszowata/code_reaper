public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final Game game = freeColServer.getGame();
    Unit unit;
    try {
        unit = getUnit(serverPlayer);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!unit.hasAbility(Ability.SPY_ON_COLONY)) {
        return serverPlayer.clientError("Unit lacks ability" + " to spy on colony: " + this.unitId);
    }
    Colony colony = getColony(game);
    if (colony == null) {
        return serverPlayer.clientError("Not a colony: " + this.settlementId);
    }
    Tile tile = colony.getTile();
    if (!unit.getTile().isAdjacent(tile)) {
        return serverPlayer.clientError("Unit " + this.unitId + " not adjacent to colony: " + this.settlementId);
    }
    MoveType type = unit.getMoveType(tile);
    if (type != MoveType.ENTER_FOREIGN_COLONY_WITH_SCOUT) {
        return serverPlayer.clientError("Unable to enter at: " + colony.getName() + ": " + type.whyIllegal());
    }
    return freeColServer.getInGameController().spySettlement(serverPlayer, unit, colony);
}