public final List<TradeRoute> getTradeRoutes() {
    synchronized (this.tradeRoutes) {
        return new ArrayList<>(this.tradeRoutes);
    }
}