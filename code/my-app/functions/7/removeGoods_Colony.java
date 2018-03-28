public Goods removeGoods(GoodsType type, int amount) {
    Goods removed = super.removeGoods(type, amount);
    productionCache.invalidate(type);
    if (removed != null)
        modifySpecialGoods(type, -removed.getAmount());
    return removed;
}