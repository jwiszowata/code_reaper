public Player getVictim() {
    TradeItem ti = find(this.items, i -> i instanceof InciteTradeItem);
    return (ti == null) ? null : ti.getVictim();
}