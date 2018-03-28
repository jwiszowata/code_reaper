private void consumeGoods(GoodsType type, int amount) {
    if (getGoodsCount(type) > 0) {
        amount = Math.min(amount, getGoodsCount(type));
        removeGoods(type, amount);
    }
}