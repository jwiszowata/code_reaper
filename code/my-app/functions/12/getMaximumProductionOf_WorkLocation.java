public int getMaximumProductionOf(GoodsType goodsType) {
    ProductionInfo info = getProductionInfo();
    if (info == null)
        return 0;
    List<AbstractGoods> production = info.getMaximumProduction();
    if (production != null) {
        AbstractGoods ag = find(production, AbstractGoods.matches(goodsType));
        if (ag != null)
            return ag.getAmount();
    }
    return getTotalProductionOf(goodsType);
}