private List<TileItem> getTileItems() {
    synchronized (tileItems) {
        return new ArrayList<TileItem>(tileItems);
    }
}