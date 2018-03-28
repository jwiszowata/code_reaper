public void setWantedGoods(int index, GoodsType type) {
    if (validWantedGoodsIndex(index))
        this.wantedGoods.set(index, type);
}