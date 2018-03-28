public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    final String tradeRouteId = getStringAttribute(TRADE_ROUTE_TAG);
    TradeRoute tradeRoute;
    try {
        tradeRoute = serverPlayer.getOurFreeColGameObject(tradeRouteId, TradeRoute.class);
    } catch (Exception e) {
        return serverPlayer.clientError(e.getMessage());
    }
    return freeColServer.getInGameController().deleteTradeRoute(serverPlayer, tradeRoute);
}