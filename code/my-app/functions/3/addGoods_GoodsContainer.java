public <T extends AbstractGoods> boolean addGoods(T goods) {
    return addGoods(goods.getType(), goods.getAmount());
}