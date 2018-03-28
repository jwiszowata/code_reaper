public void adjustAmount() {
    if (this.location == null)
        return;
    GoodsContainer gc = this.location.getGoodsContainer();
    if (gc != null) {
        int maxAmount = gc.getGoodsCount(getType());
        if (getAmount() > maxAmount)
            setAmount(maxAmount);
    }
}