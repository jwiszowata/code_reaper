public int getBaseProduction(ProductionType productionType, GoodsType goodsType, UnitType unitType) {
    Tile tile = getWorkTile();
    return (tile == null) ? 0 : tile.getBaseProduction(productionType, goodsType, unitType);
}