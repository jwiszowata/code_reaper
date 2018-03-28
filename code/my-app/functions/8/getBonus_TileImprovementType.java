public int getBonus(GoodsType goodsType) {
    Modifier result = getProductionModifier(goodsType);
    if (result == null) {
        return 0;
    } else {
        return (int) result.getValue();
    }
}