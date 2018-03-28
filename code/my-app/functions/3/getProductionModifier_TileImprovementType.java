public Modifier getProductionModifier(GoodsType goodsType) {
    return first(getModifiers(goodsType.getId()));
}