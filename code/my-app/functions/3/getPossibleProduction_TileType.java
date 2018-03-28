public Stream<AbstractGoods> getPossibleProduction(boolean unattended) {
    return flatten(getAvailableProductionTypes(unattended), pt -> pt.getOutputs());
}