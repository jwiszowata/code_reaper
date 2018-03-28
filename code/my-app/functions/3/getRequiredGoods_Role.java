public Stream<AbstractGoods> getRequiredGoods(int roleCount) {
    return getRequiredGoodsList(roleCount).stream();
}