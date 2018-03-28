private void invalidateCache() {
    final Colony colony = tile.getColony();
    if (colony != null && colony.isTileInUse(tile)) {
        colony.invalidateCache();
    }
}