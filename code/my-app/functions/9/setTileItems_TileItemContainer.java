public final void setTileItems(final List<TileItem> newTileItems) {
    clearTileItems();
    if (newTileItems != null) {
        synchronized (tileItems) {
            tileItems.addAll(newTileItems);
        }
    }
    invalidateCache();
}