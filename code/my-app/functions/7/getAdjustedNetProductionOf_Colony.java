public int getAdjustedNetProductionOf(final GoodsType goodsType) {
    final ToIntFunction<BuildQueue> consumes = q -> {
        ProductionInfo pi = productionCache.getProductionInfo(q);
        return (pi == null) ? 0 : AbstractGoods.getCount(goodsType, pi.getConsumption());
    };
    return productionCache.getNetProductionOf(goodsType) + sum(Stream.of(buildQueue, populationQueue), consumes);
}