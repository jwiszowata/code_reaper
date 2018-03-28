public AbstractGoods getBestOutputFor(GoodsType goodsType) {
    final Predicate<AbstractGoods> typePred = ag -> goodsType == null || ag.getType() == goodsType;
    return maximize(getOutputs(), typePred, AbstractGoods.ascendingAmountComparator);
}