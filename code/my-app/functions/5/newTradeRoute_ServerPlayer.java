public TradeRoute newTradeRoute() {
    TradeRoute route = new TradeRoute(getGame(), getNameForTradeRoute(), this);
    addTradeRoute(route);
    return route;
}