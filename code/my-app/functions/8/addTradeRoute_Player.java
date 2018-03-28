public final void addTradeRoute(TradeRoute tradeRoute) {
    String name;
    if (tradeRoute != null && (name = tradeRoute.getName()) != null && getTradeRouteByName(name, tradeRoute) == null) {
        synchronized (this.tradeRoutes) {
            this.tradeRoutes.add(tradeRoute);
        }
    }
}