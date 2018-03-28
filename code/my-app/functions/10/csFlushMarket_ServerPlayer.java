public boolean csFlushMarket(GoodsType type, ChangeSet cs) {
    final Market market = getMarket();
    boolean ret = market.hasPriceChanged(type);
    if (ret) {
        cs.addMessage(this, market.makePriceChangeMessage(type));
        market.flushPriceChange(type);
        cs.add(See.only(this), market.getMarketData(type));
    }
    return ret;
}