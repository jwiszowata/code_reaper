public boolean getDone() {
    return this.count < 0 || (!canBuy() && !canSell() && !canGift());
}