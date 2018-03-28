public boolean canTrade(GoodsType type) {
    return canTrade(type, Market.Access.EUROPE);
}