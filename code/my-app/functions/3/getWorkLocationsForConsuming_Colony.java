public List<WorkLocation> getWorkLocationsForConsuming(GoodsType goodsType) {
    return transform(getCurrentWorkLocations(), wl -> any(wl.getInputs(), AbstractGoods.matches(goodsType)));
}