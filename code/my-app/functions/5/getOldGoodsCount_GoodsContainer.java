public int getOldGoodsCount(GoodsType type) {
    synchronized (this.oldStoredGoods) {
        return (this.oldStoredGoods.containsKey(type)) ? this.oldStoredGoods.get(type) : 0;
    }
}