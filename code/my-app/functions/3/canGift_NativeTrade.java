public boolean canGift() {
    return getGift() && this.unit.hasGoodsCargo();
}