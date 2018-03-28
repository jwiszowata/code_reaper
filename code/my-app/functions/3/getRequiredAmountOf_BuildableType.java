public int getRequiredAmountOf(GoodsType type) {
    return AbstractGoods.getCount(type, getRequiredGoodsList());
}