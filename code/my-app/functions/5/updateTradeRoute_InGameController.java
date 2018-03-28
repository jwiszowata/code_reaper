public boolean updateTradeRoute(TradeRoute route) {
    if (route == null)
        return false;
    return askServer().updateTradeRoute(route);
}