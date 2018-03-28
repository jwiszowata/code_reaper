public void update(GoodsType goodsType, int amount, int value) {
    this.goodsType = goodsType;
    this.amountRequested = amount;
    setValue(value);
    if (transportable != null)
        transportable.incrementTransportPriority();
}