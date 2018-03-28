public AbstractGoods getProductionDeficit(GoodsType goodsType) {
    ProductionInfo pi = getProductionInfo();
    return (pi == null) ? null : find(pi.getProductionDeficit(), AbstractGoods.matches(goodsType));
}