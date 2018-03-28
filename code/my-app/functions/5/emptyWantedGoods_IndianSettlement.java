private static List<GoodsType> emptyWantedGoods() {
    List<GoodsType> ret = new ArrayList<>(WANTED_GOODS_COUNT);
    for (int i = 0; i < WANTED_GOODS_COUNT; i++) ret.add(null);
    return ret;
}