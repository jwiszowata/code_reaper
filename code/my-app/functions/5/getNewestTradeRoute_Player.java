public final TradeRoute getNewestTradeRoute() {
    synchronized (this.tradeRoutes) {
        return (this.tradeRoutes.isEmpty()) ? null : this.tradeRoutes.get(this.tradeRoutes.size() - 1);
    }
}