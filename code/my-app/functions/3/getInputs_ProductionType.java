public final Stream<AbstractGoods> getInputs() {
    return (inputs == null) ? Stream.<AbstractGoods>empty() : inputs.stream();
}