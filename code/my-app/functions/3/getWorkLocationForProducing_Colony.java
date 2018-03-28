public WorkLocation getWorkLocationForProducing(GoodsType goodsType) {
    return first(getWorkLocationsForProducing(goodsType));
}