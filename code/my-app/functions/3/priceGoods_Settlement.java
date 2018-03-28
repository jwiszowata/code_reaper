public int priceGoods(List<AbstractGoods> goods) {
    return (any(goods, ag -> getGoodsCount(ag.getType()) < ag.getAmount())) ? -1 : 0;
}