public final boolean addGoods(List<AbstractGoods> goods) {
    return all(goods, ag -> addGoods(ag));
}