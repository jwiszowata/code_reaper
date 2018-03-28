public List<GoodsType> getProductionChain() {
    List<GoodsType> result = new ArrayList<>();
    GoodsType currentGoods = this;
    while (currentGoods != null) {
        result.add(0, currentGoods);
        currentGoods = currentGoods.madeFrom;
    }
    return result;
}