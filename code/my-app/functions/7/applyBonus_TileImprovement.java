public int applyBonus(GoodsType goodsType, UnitType unitType, int potential) {
    int result = potential;
    if (potential > 0 && isComplete()) {
        result += type.getBonus(goodsType);
    }
    return result;
}