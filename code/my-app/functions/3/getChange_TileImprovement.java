public TileType getChange(TileType tileType) {
    return (isComplete()) ? type.getChange(tileType) : null;
}