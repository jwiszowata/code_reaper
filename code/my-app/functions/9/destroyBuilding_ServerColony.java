public boolean destroyBuilding(Building building) {
    Tile copied = (building.getType().isDefenceType()) ? getTile().getTileToCache() : null;
    if (!removeBuilding(building))
        return false;
    getTile().cacheUnseen(copied);
    invalidateCache();
    checkBuildQueueIntegrity(true);
    return true;
}