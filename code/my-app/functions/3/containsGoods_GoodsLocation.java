public final boolean containsGoods(List<AbstractGoods> goods) {
    return all(goods, ag -> ag.getAmount() <= getGoodsCount(ag.getType()));
}