public GoodsType getProducedGoodsType() {
    if (productionTypes.isEmpty())
        return null;
    AbstractGoods ag = first(first(productionTypes).getOutputs());
    return (ag == null) ? null : ag.getType();
}