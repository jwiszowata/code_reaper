public int getExportAmount(GoodsType goodsType, int turns) {
    int present = Math.max(0, getGoodsCount(goodsType) + turns * getTotalProductionOf(goodsType));
    int wanted = getWantedGoodsAmount(goodsType);
    return present - wanted;
}