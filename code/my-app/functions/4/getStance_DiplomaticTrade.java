public Stance getStance() {
    TradeItem ti = find(this.items, i -> i instanceof StanceTradeItem);
    return (ti == null) ? null : ti.getStance();
}