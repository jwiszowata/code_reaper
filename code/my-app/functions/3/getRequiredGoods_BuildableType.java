public Stream<AbstractGoods> getRequiredGoods() {
    return (this.requiredGoods == null) ? Stream.<AbstractGoods>empty() : getRequiredGoodsList().stream();
}