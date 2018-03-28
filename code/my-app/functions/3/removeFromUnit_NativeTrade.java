public void removeFromUnit(NativeTradeItem nti) {
    removeInPlace(this.unitToSettlement, nti.goodsMatcher());
}