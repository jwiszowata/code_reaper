public AbstractGoods getProduction(TileType from) {
    if (tileTypeChanges == null)
        return null;
    TileTypeChange change = tileTypeChanges.get(from);
    return (change == null) ? null : change.getProduction();
}