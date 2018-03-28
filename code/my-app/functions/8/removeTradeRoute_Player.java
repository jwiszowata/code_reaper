public final List<Unit> removeTradeRoute(TradeRoute tradeRoute) {
    List<Unit> ret;
    synchronized (this.tradeRoutes) {
        ret = (!this.tradeRoutes.remove(tradeRoute)) ? Collections.<Unit>emptyList() : tradeRoute.getAssignedUnits();
    }
    for (Unit u : ret) u.setTradeRoute(null);
    return ret;
}