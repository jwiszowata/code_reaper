public Stream<AbstractGoods> getOutputs() {
    return (productionType == null) ? Stream.<AbstractGoods>empty() : productionType.getOutputs();
}