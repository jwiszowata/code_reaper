public int getTotalBonusPotential(GoodsType goodsType, UnitType unitType, int potential, boolean onlyNatural) {
    int result = potential;
    for (TileItem item : transform(getTileItems(), ti -> !onlyNatural || ti.isNatural())) {
        result = item.applyBonus(goodsType, unitType, result);
    }
    return result;
}