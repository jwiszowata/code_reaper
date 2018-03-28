public static ProductionType getBestProductionType(GoodsType goodsType, Collection<ProductionType> types) {
    final Comparator<ProductionType> comp = cachingIntComparator(pt -> {
        AbstractGoods best = pt.getBestOutputFor(goodsType);
        return (best == null) ? Integer.MIN_VALUE : best.getAmount();
    });
    return maximize(types, comp);
}