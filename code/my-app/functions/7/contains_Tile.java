public boolean contains(Locatable locatable) {
    if (locatable instanceof TileItem) {
        return tileItemContainer != null && tileItemContainer.contains((TileItem) locatable);
    } else {
        return super.contains(locatable);
    }
}