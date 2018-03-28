public int getTotalProductionOf(GoodsType goodsType) {
    return sum(getCurrentWorkLocations(), wl -> wl.getTotalProductionOf(goodsType));
}