public Predicate<NativeTradeItem> goodsMatcher() {
    return matchKeyEquals(this.getGoods(), NativeTradeItem::getGoods);
}