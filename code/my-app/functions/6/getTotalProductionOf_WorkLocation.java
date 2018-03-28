public int getTotalProductionOf(GoodsType goodsType) {
    if (goodsType == null) {
        throw new IllegalArgumentException("Null GoodsType.");
    }
    return AbstractGoods.getCount(goodsType, getProduction());
}