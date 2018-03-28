private <T extends TileItem> T removeTileItem(T item) {
    if (item == null || tileItemContainer == null)
        return null;
    return tileItemContainer.removeTileItem(item);
}