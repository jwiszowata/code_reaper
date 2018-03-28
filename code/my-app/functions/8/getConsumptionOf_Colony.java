public int getConsumptionOf(GoodsType goodsType) {
    final Specification spec = getSpecification();
    int result = super.getConsumptionOf(goodsType);
    if (spec.getGoodsType("model.goods.bells").equals(goodsType)) {
        result -= spec.getInteger("model.option.unitsThatUseNoBells");
    }
    return Math.max(0, result);
}