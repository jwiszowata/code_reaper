public final Stream<AbstractGoods> getOutputs() {
    return (outputs == null) ? Stream.<AbstractGoods>empty() : outputs.stream();
}