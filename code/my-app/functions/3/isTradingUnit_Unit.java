public boolean isTradingUnit() {
    return canCarryGoods() && owner.isEuropean();
}