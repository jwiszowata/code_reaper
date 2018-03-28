public final TileItem tryAddTileItem(TileItem item) {
    if (item == null)
        return null;
    List<TileItem> items = getTileItems();
    for (int index = 0; index < items.size(); index++) {
        TileItem oldItem = items.get(index);
        if (item instanceof TileImprovement && oldItem instanceof TileImprovement) {
            TileImprovement oldTip = (TileImprovement) oldItem;
            TileImprovement newTip = (TileImprovement) item;
            if (oldTip.getType().getId().equals(newTip.getType().getId())) {
                if (oldTip.getMagnitude() < newTip.getMagnitude()) {
                    synchronized (tileItems) {
                        tileItems.set(index, item);
                    }
                    oldItem.dispose();
                    invalidateCache();
                    return item;
                } else {
                    return oldItem;
                }
            } else if (oldItem.getZIndex() > item.getZIndex()) {
                break;
            }
        }
    }
    addTileItem(item);
    invalidateCache();
    return item;
}