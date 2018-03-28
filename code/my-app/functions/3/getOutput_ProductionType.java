public AbstractGoods getOutput(GoodsType goodsType) {
    return (outputs == null) ? null : find(outputs, AbstractGoods.matches(goodsType));
}