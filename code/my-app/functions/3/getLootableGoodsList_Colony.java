public List<Goods> getLootableGoodsList() {
    return transform(getGoodsContainer().getGoods(), AbstractGoods::isStorable);
}