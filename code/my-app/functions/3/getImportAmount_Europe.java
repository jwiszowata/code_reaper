public int getImportAmount(GoodsType goodsType, int turns) {
    return (getOwner().canTrade(goodsType)) ? GoodsContainer.HUGE_CARGO_SIZE : 0;
}