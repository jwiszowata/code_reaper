public boolean deleteTradeRoute(TradeRoute tradeRoute) {
    final Player player = getMyPlayer();
    final String name = tradeRoute.getName();
    boolean ret = askServer().deleteTradeRoute(tradeRoute);
    return ret && player.getTradeRouteByName(name, null) == null;
}