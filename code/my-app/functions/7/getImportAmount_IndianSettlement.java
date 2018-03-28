public int getImportAmount(GoodsType goodsType, int turns) {
    if (goodsType.limitIgnored())
        return Integer.MAX_VALUE;
    int present = Math.max(0, getGoodsCount(goodsType) - turns * getTotalProductionOf(goodsType));
    int capacity = getWarehouseCapacity();
    return capacity - present;
}