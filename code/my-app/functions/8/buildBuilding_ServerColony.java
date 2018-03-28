public boolean buildBuilding(Building building) {
    Tile copied = (building.getType().isDefenceType()) ? getTile().getTileToCache() : null;
    if (!addBuilding(building))
        return false;
    getTile().cacheUnseen(copied);
    invalidateCache();
    return true;
}