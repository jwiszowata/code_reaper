public int getGoodsSpaceTaken() {
    if (!canCarryGoods())
        return 0;
    GoodsContainer gc = getGoodsContainer();
    return (gc == null) ? 0 : gc.getSpaceTaken();
}