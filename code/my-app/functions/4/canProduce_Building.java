public boolean canProduce(GoodsType goodsType, UnitType unitType) {
    final BuildingType type = getType();
    return type != null && type.canProduce(goodsType, unitType);
}