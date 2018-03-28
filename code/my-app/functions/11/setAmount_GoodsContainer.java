public void setAmount(GoodsType goodsType, int newAmount) {
    if (newAmount == 0) {
        synchronized (this.storedGoods) {
            this.storedGoods.remove(goodsType);
        }
    } else {
        synchronized (this.storedGoods) {
            this.storedGoods.put(goodsType, newAmount);
        }
    }
}