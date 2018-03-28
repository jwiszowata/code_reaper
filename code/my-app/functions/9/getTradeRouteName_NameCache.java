public static String getTradeRouteName(Player player) {
    String base = Messages.message("nameCache.base.tradeRoute");
    if (player.getTradeRouteByName(base, null) == null)
        return base;
    String name;
    int i = 1;
    while (player.getTradeRouteByName(name = base + i++, null) != null) ;
    return name;
}