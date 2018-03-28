public TileType getChange(TileType tileType) {
    if (tileTypeChanges == null)
        return null;
    TileTypeChange change = tileTypeChanges.get(tileType);
    return (change == null) ? null : change.getTo();
}