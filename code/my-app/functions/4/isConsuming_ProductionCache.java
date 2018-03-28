public boolean isConsuming(GoodsType goodsType) {
    update();
    return any(productionAndConsumption.values(), pi -> any(pi.getConsumption(), AbstractGoods.matches(goodsType)));
}