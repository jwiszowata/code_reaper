public void removeType(Class<? extends TradeItem> itemClass) {
    removeInPlace(this.items, matchKey(itemClass, TradeItem::getClass));
}