public List<Unit> getUnitsGivenBy(Player player) {
    return transform(this.items, ti -> ti instanceof UnitTradeItem && ti.getSource() == player, TradeItem::getUnit);
}