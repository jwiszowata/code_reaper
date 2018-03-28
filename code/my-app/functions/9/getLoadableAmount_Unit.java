public int getLoadableAmount(GoodsType type) {
    if (!canCarryGoods())
        return 0;
    int result = getSpaceLeft() * GoodsContainer.CARGO_SIZE;
    int count = getGoodsCount(type) % GoodsContainer.CARGO_SIZE;
    if (count != 0)
        result += GoodsContainer.CARGO_SIZE - count;
    return result;
}