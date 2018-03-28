public boolean addGoods(GoodsType type, int amount) {
    super.addGoods(type, amount);
    productionCache.invalidate(type);
    modifySpecialGoods(type, amount);
    return true;
}