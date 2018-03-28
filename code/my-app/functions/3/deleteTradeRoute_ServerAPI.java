public boolean deleteTradeRoute(TradeRoute tradeRoute) {
    return ask(tradeRoute.getGame(), new DeleteTradeRouteMessage(tradeRoute));
}