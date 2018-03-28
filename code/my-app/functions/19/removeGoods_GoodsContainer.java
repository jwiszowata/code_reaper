public Goods removeGoods(GoodsType type, int amount) {
    int oldAmount = getGoodsCount(type);
    if (oldAmount <= 0)
        return null;
    int newAmount = oldAmount - amount;
    Goods removedGoods;
    if (newAmount > 0) {
        removedGoods = new Goods(getGame(), null, type, amount);
        synchronized (this.storedGoods) {
            this.storedGoods.put(type, newAmount);
        }
    } else {
        removedGoods = new Goods(getGame(), null, type, oldAmount);
        synchronized (this.storedGoods) {
            this.storedGoods.remove(type);
        }
    }
    return removedGoods;
}