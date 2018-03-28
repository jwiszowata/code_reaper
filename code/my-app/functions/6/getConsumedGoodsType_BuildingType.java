private GoodsType getConsumedGoodsType() {
    if (productionTypes.isEmpty())
        return null;
    AbstractGoods ag = first(first(productionTypes).getInputs());
    return (ag == null) ? null : ag.getType();
}