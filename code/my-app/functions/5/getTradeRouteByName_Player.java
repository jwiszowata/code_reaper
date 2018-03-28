public final TradeRoute getTradeRouteByName(final String name, final TradeRoute exclude) {
    synchronized (this.tradeRoutes) {
        return find(this.tradeRoutes, t -> t.getName().equals(name) && t != exclude);
    }
}