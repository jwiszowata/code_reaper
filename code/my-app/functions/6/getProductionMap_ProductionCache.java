public TypeCountMap<GoodsType> getProductionMap() {
    update();
    TypeCountMap<GoodsType> result = new TypeCountMap<>();
    result.putAll(netProduction);
    return result;
}