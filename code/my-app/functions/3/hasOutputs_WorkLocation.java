public boolean hasOutputs() {
    return productionType != null && any(productionType.getOutputs());
}