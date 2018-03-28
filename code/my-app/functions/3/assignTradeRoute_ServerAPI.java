public boolean assignTradeRoute(Unit unit, TradeRoute tradeRoute) {
    return ask(unit.getGame(), new AssignTradeRouteMessage(unit, tradeRoute));
}