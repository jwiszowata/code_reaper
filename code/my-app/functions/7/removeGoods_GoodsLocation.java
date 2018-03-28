public Goods removeGoods(GoodsType type, int amount) {
    if (goodsContainer == null)
        return null;
    Goods ret = goodsContainer.removeGoods(type, amount);
    invalidateCache();
    return ret;
}