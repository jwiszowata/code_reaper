public MapBuilder setBaseTileType(TileType baseType) {
    if (baseType == null) {
        throw new NullPointerException("Base tile type cannot be null");
    }
    this.baseTile = baseType;
    return this;
}