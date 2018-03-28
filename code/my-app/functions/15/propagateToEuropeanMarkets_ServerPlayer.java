public void propagateToEuropeanMarkets(GoodsType type, int amount, Random random) {
    if (!type.isStorable())
        return;
    final int lowerBound = 5;
    final int upperBound = 30;
    amount *= randomInt(logger, "Propagate goods", random, upperBound - lowerBound + 1) + lowerBound;
    amount /= 100;
    if (amount == 0)
        return;
    for (Player p : getGame().getLiveEuropeanPlayerList(this)) {
        Market market = p.getMarket();
        if (market != null)
            market.addGoodsToMarket(type, amount);
    }
}