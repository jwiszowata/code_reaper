public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String directionString = getStringAttribute(DIRECTION_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (unit.isArmed() || unit.hasAbility(Ability.DEMAND_TRIBUTE)) {
        ;
    } else {
        return serverPlayer.clientError("Unit is neither armed" + " nor able to demand tribute: " + unitId);
    }
    Tile tile;
    try {
        tile = unit.getNeighbourTile(directionString);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    IndianSettlement is = tile.getIndianSettlement();
    if (is == null) {
        return serverPlayer.clientError("There is native settlement at: " + tile.getId());
    }
    MoveType type = unit.getMoveType(tile);
    if (type != MoveType.ATTACK_SETTLEMENT && type != MoveType.ENTER_INDIAN_SETTLEMENT_WITH_SCOUT) {
        return serverPlayer.clientError("Unable to demand tribute at: " + is.getName() + ": " + type.whyIllegal());
    }
    return freeColServer.getInGameController().demandTribute(serverPlayer, unit, is);
}