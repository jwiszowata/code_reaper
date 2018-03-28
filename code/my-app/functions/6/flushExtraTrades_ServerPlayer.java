public void flushExtraTrades(Random random) {
    while (!extraTrades.isEmpty()) {
        AbstractGoods ag = extraTrades.remove(0);
        propagateToEuropeanMarkets(ag.getType(), ag.getAmount(), random);
    }
}