public List<TradeItem> getItemsGivenBy(Player player) {
    return transform(this.items, matchKey(player, TradeItem::getSource));
}