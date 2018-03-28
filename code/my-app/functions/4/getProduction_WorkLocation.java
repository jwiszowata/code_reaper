public List<AbstractGoods> getProduction() {
    ProductionInfo info = getProductionInfo();
    return (info == null) ? EMPTY_LIST : info.getProduction();
}