public boolean willSell(GoodsType type) {
    return !type.isTradeGoods();
}