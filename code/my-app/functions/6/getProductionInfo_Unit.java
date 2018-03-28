public ProductionInfo getProductionInfo(List<AbstractGoods> input) {
    ProductionInfo result = new ProductionInfo();
    result.setConsumption(getType().getConsumedGoods());
    result.setMaximumConsumption(getType().getConsumedGoods());
    return result;
}