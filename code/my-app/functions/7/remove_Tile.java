public boolean remove(Locatable locatable) {
    if (locatable instanceof TileItem) {
        return removeTileItem((TileItem) locatable) == locatable;
    } else {
        return super.remove(locatable);
    }
}