public <T extends AbstractGoods> boolean satisfiedBy(T goods) {
    return goods.getType() == goodsType && goods.getAmount() >= amountRequested;
}