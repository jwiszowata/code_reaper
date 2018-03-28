public final int getTradeRouteCount() {
    synchronized (this.tradeRoutes) {
        return this.tradeRoutes.size();
    }
}