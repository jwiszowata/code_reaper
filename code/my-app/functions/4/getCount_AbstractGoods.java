public static int getCount(GoodsType type, Collection<? extends AbstractGoods> goods) {
    AbstractGoods ag = find(goods, matches(type));
    return (ag == null) ? 0 : ag.getAmount();
}