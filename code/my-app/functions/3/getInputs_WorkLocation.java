public Stream<AbstractGoods> getInputs() {
    return (productionType == null) ? Stream.<AbstractGoods>empty() : productionType.getInputs();
}