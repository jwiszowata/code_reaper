public Modifier getProductionModifier(GoodsType goodsType) {
    return (isComplete()) ? type.getProductionModifier(goodsType) : null;
}