public List<TileItem> getCompleteItems() {
    return transform(getTileItems(), TileItem::isComplete);
}