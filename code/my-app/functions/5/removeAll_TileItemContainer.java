public final <T extends TileItem> void removeAll(Class<T> c) {
    synchronized (tileItems) {
        removeInPlace(tileItems, ti -> c.isInstance(ti));
    }
}