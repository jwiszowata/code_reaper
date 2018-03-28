public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String improvementId = getStringAttribute(IMPROVEMENT_TYPE_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    Tile tile = unit.getTile();
    if (tile == null) {
        return serverPlayer.clientError("Unit is not on the map: " + unitId);
    } else if (!unit.hasAbility(Ability.IMPROVE_TERRAIN)) {
        return serverPlayer.clientError("Unit can not improve tiles: " + unitId);
    }
    TileImprovementType type = freeColServer.getSpecification().getTileImprovementType(improvementId);
    TileImprovement improvement;
    if (type == null) {
        return serverPlayer.clientError("Not a tile improvement type: " + improvementId);
    } else if (type.isNatural()) {
        return serverPlayer.clientError("ImprovementType must not be natural: " + improvementId);
    } else if (!type.isTileTypeAllowed(tile.getType())) {
        return serverPlayer.clientError("ImprovementType not allowed on tile: " + improvementId);
    } else if ((improvement = tile.getTileImprovement(type)) == null) {
        if (!type.isWorkerAllowed(unit)) {
            return serverPlayer.clientError("Unit can not create improvement: " + improvementId);
        }
    } else {
        if (!improvement.isWorkerAllowed(unit)) {
            return serverPlayer.clientError("Unit can not work on improvement: " + improvementId);
        }
    }
    return freeColServer.getInGameController().changeWorkImprovementType(serverPlayer, unit, type);
}