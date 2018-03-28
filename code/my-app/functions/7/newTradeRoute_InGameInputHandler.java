private void newTradeRoute(NewTradeRouteMessage message) {
    final Game game = getGame();
    final Player player = getMyPlayer();
    final TradeRoute tr = message.getTradeRoute();
    if (player != null && tr != null)
        player.addTradeRoute(tr);
}