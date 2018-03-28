public boolean contains(TileItem t) {
    synchronized (tileItems) {
        return tileItems.contains(t);
    }
}