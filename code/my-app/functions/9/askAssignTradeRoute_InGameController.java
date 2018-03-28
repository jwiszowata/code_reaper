private boolean askAssignTradeRoute(Unit unit, TradeRoute tradeRoute) {
    if (tradeRoute == unit.getTradeRoute())
        return true;
    if (tradeRoute != null && unit.getTradeRoute() != null) {
        if (!getGUI().confirmClearTradeRoute(unit))
            return false;
    }
    return askServer().assignTradeRoute(unit, tradeRoute) && unit.getTradeRoute() == tradeRoute;
}