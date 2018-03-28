public final int getGoodsCount(GoodsType type) {
    return (goodsContainer == null) ? 0 : goodsContainer.getGoodsCount(type);
}