private Resource expendResource(Tile tile, GoodsType goodsType, UnitType unitType) {
    if (!tile.hasResource())
        return null;
    Resource resource = tile.getResource();
    if (resource.isUnlimited())
        return null;
    if (resource.useQuantity(goodsType, unitType, tile.getPotentialProduction(goodsType, unitType)) == 0) {
        tile.cacheUnseen();
        tile.removeResource();
        return resource;
    }
    return null;
}