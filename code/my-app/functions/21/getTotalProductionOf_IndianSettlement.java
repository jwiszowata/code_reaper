public int getTotalProductionOf(GoodsType type) {
    if (type.isRefined()) {
        if (type != goodsToMake())
            return 0;
        return getUnitCount();
    }
    int tiles = 0;
    int potential = 0;
    for (Tile wt : transform(getOwnedTiles(), t -> t != getTile() && !t.isOccupied())) {
        potential += wt.getPotentialProduction(type, null);
        tiles++;
    }
    if (tiles > getUnitCount()) {
        potential *= (float) getUnitCount() / tiles;
    }
    if (!type.isFoodType()) {
        potential = (int) Math.round(potential * NATIVE_PRODUCTION_EFFICIENCY);
    }
    potential += getTile().getPotentialProduction(type, null);
    return potential;
}