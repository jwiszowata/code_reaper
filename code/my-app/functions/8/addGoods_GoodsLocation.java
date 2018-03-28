public boolean addGoods(GoodsType type, int amount) {
    if (goodsContainer == null) {
        goodsContainer = new GoodsContainer(getGame(), this);
    }
    boolean ret = goodsContainer.addGoods(type, amount);
    invalidateCache();
    return ret;
}