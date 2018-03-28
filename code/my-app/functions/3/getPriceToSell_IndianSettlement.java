public <T extends AbstractGoods> int getPriceToSell(T goods) {
    return getPriceToSell(goods.getType(), goods.getAmount());
}