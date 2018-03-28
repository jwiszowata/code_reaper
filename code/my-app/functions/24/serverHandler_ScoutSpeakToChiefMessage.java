public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String settlementId = getStringAttribute(SETTLEMENT_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    if (!unit.hasAbility(Ability.SPEAK_WITH_CHIEF)) {
        return serverPlayer.clientError("Unit lacks ability to speak to chief: " + unitId);
    }
    IndianSettlement is;
    try {
        is = unit.getAdjacentSettlement(settlementId, IndianSettlement.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    MoveType type = unit.getMoveType(is.getTile());
    if (type != MoveType.ENTER_INDIAN_SETTLEMENT_WITH_SCOUT) {
        return serverPlayer.clientError("Unable to enter " + is.getName() + ": " + type.whyIllegal());
    }
    return freeColServer.getInGameController().scoutSpeakToChief(serverPlayer, unit, is);
}