public void removeIncompatibleImprovements() {
    TileType tileType = tile.getType();
    boolean removed = false;
    synchronized (tileItems) {
        TileImprovement river = getRiver();
        if (river != null && !river.isTileTypeAllowed(tileType) && !tileType.isWater()) {
            river.updateRiverConnections(null);
        }
        removed = removeInPlace(tileItems, ti -> !ti.isTileTypeAllowed(tileType));
    }
    if (removed)
        invalidateCache();
}