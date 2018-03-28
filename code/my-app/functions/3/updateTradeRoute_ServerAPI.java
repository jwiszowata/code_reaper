public boolean updateTradeRoute(TradeRoute route) {
    return ask(route.getGame(), new UpdateTradeRouteMessage(route));
}