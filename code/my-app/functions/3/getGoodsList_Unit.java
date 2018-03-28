public List<Goods> getGoodsList() {
    return (getGoodsContainer() == null) ? Collections.<Goods>emptyList() : getGoodsContainer().getGoods();
}