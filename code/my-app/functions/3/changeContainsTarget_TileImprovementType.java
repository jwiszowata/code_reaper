public boolean changeContainsTarget(TileType tileType) {
    return (tileTypeChanges == null) ? false : any(tileTypeChanges.values(), matchKey(tileType, TileTypeChange::getTo));
}