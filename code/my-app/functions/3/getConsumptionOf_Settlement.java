public int getConsumptionOf(List<GoodsType> goodsTypes) {
    return (goodsTypes == null) ? 0 : sum(goodsTypes, gt -> getConsumptionOf(gt));
}