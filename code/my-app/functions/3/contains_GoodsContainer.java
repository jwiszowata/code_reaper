public <T extends AbstractGoods> boolean contains(T g) {
    return getGoodsCount(g.getType()) >= g.getAmount();
}