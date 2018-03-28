public boolean canProduce(GoodsType goodsType, UnitType unitType) {
    final Tile workTile = getWorkTile();
    return workTile != null && workTile.canProduce(goodsType, unitType);
}