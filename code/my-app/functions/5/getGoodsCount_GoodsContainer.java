public int getGoodsCount(GoodsType type) {
    synchronized (this.storedGoods) {
        return (this.storedGoods.containsKey(type)) ? this.storedGoods.get(type) : 0;
    }
}