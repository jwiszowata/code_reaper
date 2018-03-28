public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String indexString = getStringAttribute(INDEX_TAG);
    ServerUnit serverUnit;
    try {
        serverUnit = serverPlayer.getOurFreeColGameObject(unitId, ServerUnit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    TradeRoute tr = serverUnit.getTradeRoute();
    if (tr == null) {
        return serverPlayer.clientError("Unit has no trade route: " + unitId);
    }
    int count;
    try {
        count = Integer.parseInt(indexString);
    } catch (NumberFormatException nfe) {
        return serverPlayer.clientError("Stop index is not an integer: " + indexString);
    }
    if (count < 0 || count > tr.getStops().size()) {
        return serverPlayer.clientError("Invalid stop index: " + indexString);
    }
    return freeColServer.getInGameController().setCurrentStop(serverPlayer, serverUnit, count);
}