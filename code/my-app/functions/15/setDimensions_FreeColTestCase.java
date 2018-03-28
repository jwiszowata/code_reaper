public MapBuilder setDimensions(int width, int heigth) {
    if (width <= 0) {
        throw new IllegalArgumentException("Width must be positive");
    }
    if (heigth <= 0) {
        throw new IllegalArgumentException("Heigth must be positive");
    }
    if (initiated) {
        throw new IllegalStateException("Cannot resize map after setting a tile");
    }
    this.width = width;
    this.height = heigth;
    this.tiles = new TileType[width][height];
    return this;
}