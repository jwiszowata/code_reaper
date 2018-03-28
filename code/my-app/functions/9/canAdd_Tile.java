public boolean canAdd(Locatable locatable) {
    if (locatable instanceof Unit) {
        return ((Unit) locatable).isTileAccessible(this);
    } else if (locatable instanceof TileImprovement) {
        return ((TileImprovement) locatable).getType().isTileTypeAllowed(getType());
    } else {
        return false;
    }
}