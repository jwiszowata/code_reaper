private int getAvailable(GoodsType type, List<AbstractGoods> available) {
    return AbstractGoods.getCount(type, available);
}