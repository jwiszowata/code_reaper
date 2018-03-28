public void removeTradeItems(Class<? extends TradeItem> itemClass) {
    this.agreement.removeType(itemClass);
    updateDialog();
}