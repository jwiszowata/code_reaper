private int ReturnPresent(GoodsType goodsType, int turns) {
    final int present = Math.max(0, getGoodsCount(goodsType) + turns * getNetProductionOf(goodsType));
    return present;
}