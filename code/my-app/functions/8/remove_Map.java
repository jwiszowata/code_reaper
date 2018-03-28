public boolean remove(Locatable locatable) {
    if (locatable instanceof Unit) {
        Tile tile = locatable.getTile();
        if (tile != null)
            return tile.remove(locatable);
    }
    return false;
}