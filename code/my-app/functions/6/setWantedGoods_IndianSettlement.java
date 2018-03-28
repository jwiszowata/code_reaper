public void setWantedGoods(List<GoodsType> wanted) {
    final int n = wanted.size();
    for (int i = 0; i < WANTED_GOODS_COUNT; i++) {
        this.wantedGoods.set(i, ((i < n) ? wanted.get(i) : null));
    }
}