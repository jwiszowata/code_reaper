public static boolean isStopValid(Player player, TradeRouteStop stop) {
    return (stop == null) ? false : stop.isValid(player);
}