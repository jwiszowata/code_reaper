public List<Goods> getCompactGoodsList() {
    return (getGoodsContainer() == null) ? Collections.<Goods>emptyList() : getGoodsContainer().getCompactGoods();
}