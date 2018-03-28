public final <T extends TileItem> T removeTileItem(T item) {
    boolean removed;
    synchronized (tileItems) {
        removed = tileItems.remove(item);
    }
    if (removed) {
        item.setLocation(null);
        invalidateCache();
        return item;
    }
    return null;
}