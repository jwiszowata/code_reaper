private TileItem findTileItem(Predicate<TileItem> pred) {
    synchronized (tileItems) {
        return find(tileItems, pred);
    }
}