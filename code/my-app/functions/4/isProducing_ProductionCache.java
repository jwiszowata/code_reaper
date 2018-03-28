public boolean isProducing(GoodsType goodsType) {
    update();
    return any(productionAndConsumption.values(), pi -> any(pi.getProduction(), AbstractGoods.matches(goodsType)));
}