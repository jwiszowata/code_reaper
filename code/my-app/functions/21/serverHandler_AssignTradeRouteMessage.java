public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String unitId = getStringAttribute(UNIT_TAG);
    final String tradeRouteId = getStringAttribute(TRADE_ROUTE_TAG);
    Unit unit;
    try {
        unit = serverPlayer.getOurFreeColGameObject(unitId, Unit.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    TradeRoute tradeRoute;
    if (tradeRouteId == null) {
        tradeRoute = null;
    } else {
        try {
            tradeRoute = serverPlayer.getOurFreeColGameObject(tradeRouteId, TradeRoute.class);
        } catch (Exception e) {
            return serverPlayer.clientError(e.getMessage());
        }
    }
    return freeColServer.getInGameController().assignTradeRoute(serverPlayer, unit, tradeRoute);
}