public <T extends AbstractGoods> int getPriceToBuy(T goods) {
    return getPriceToBuy(goods.getType(), goods.getAmount());
}