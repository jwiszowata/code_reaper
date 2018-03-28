private int getAmount(Location location, GoodsType goodsType) {
    if (goodsType == null)
        return 0;
    if (location instanceof WorkLocation) {
        ProductionInfo info = ((WorkLocation) location).getProductionInfo();
        return AbstractGoods.getCount(goodsType, info.getProduction());
    }
    return 0;
}