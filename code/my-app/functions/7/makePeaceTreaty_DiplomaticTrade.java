public static DiplomaticTrade makePeaceTreaty(TradeContext context, Player sender, Player recipient) {
    final Game game = sender.getGame();
    DiplomaticTrade dt = new DiplomaticTrade(game, context, sender, recipient, null, 0);
    dt.add(new StanceTradeItem(game, sender, recipient, Stance.PEACE));
    dt.add(new StanceTradeItem(game, recipient, sender, Stance.PEACE));
    return dt;
}