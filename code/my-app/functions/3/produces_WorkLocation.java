public boolean produces(GoodsType goodsType) {
    return any(getOutputs(), AbstractGoods.matches(goodsType));
}