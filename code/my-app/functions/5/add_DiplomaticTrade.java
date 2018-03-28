public void add(TradeItem newItem) {
    if (newItem.isUnique())
        removeType(newItem.getClass());
    this.items.add(newItem);
}