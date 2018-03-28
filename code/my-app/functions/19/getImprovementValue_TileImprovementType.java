public int getImprovementValue(Tile tile, GoodsType goodsType) {
    final UnitType colonistType = getSpecification().getDefaultUnitType();
    int value = 0;
    if (goodsType.isFarmed()) {
        final int oldProduction = tile.getType().getPotentialProduction(goodsType, colonistType);
        TileType tt = getChange(tile.getType());
        if (tt == null) {
            int production = tile.getPotentialProduction(goodsType, colonistType);
            if (production > 0) {
                float chg = applyModifiers(production, null, goodsType.getId());
                value = (int) (chg - production);
            }
        } else {
            int chg = tt.getPotentialProduction(goodsType, colonistType) - oldProduction;
            value = chg;
        }
    }
    return value;
}