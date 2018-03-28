private void clearTradeRoutes() {
    synchronized (this.tradeRoutes) {
        this.tradeRoutes.clear();
    }
}