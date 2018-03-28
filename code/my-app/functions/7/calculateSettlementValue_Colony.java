public int calculateSettlementValue(int value, Unit unit) {
    value += this.getUnitCount();
    if (this.hasStockade()) {
        value -= 200 * this.getStockade().getLevel();
    }
    return value;
}