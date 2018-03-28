private boolean addTileItem(TileItem item) {
    if (item == null)
        return false;
    if (tileItemContainer == null) {
        tileItemContainer = new TileItemContainer(getGame(), this);
    }
    TileItem added = tileItemContainer.tryAddTileItem(item);
    return added == item;
}