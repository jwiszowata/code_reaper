public <T extends AbstractGoods> int getSalePrice(T goods) {
    return getSalePrice(goods.getType(), goods.getAmount());
}