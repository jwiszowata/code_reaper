private final void addTileItem(TileItem item) {
    synchronized (tileItems) {
        tileItems.add(item);
    }
}