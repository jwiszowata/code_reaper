public GoodsType getWantedGoods(int index) {
    return (validWantedGoodsIndex(index)) ? this.wantedGoods.get(index) : null;
}