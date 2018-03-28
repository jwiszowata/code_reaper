public int getGoldGivenBy(Player player) {
    TradeItem ti = find(this.items, i -> i instanceof GoldTradeItem && player == i.getSource());
    return (ti == null) ? -1 : ti.getGold();
}