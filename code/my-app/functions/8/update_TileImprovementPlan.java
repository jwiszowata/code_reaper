public boolean update(GoodsType goodsType) {
    TileImprovementType type = getBestTileImprovementType(target, goodsType);
    if (type == null)
        return false;
    setType(type);
    setValue(type.getImprovementValue(target, goodsType));
    return true;
}