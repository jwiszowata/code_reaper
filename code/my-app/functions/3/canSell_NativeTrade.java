public boolean canSell() {
    return getSell() && !atWar() && any(getUnitToSettlement(), NativeTradeItem::priceIsValid);
}