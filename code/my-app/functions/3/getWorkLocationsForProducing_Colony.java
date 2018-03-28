public List<WorkLocation> getWorkLocationsForProducing(GoodsType goodsType) {
    return transform(getCurrentWorkLocations(), wl -> any(wl.getOutputs(), AbstractGoods.matches(goodsType)));
}