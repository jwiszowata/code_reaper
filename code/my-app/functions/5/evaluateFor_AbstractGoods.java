public int evaluateFor(Player player) {
    final Market market = player.getMarket();
    return // FIXME: magic#
    (market == null) ? getAmount() * 2 : market.getSalePrice(getType(), getAmount());
}