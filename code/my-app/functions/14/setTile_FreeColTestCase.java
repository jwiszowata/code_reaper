public MapBuilder setTile(int x, int y, TileType tileType) {
    if (x < 0 || y < 0) {
        throw new IllegalArgumentException("Coordenates cannot be negative");
    }
    if (x >= width || y >= height) {
        throw new IllegalArgumentException("Coordenate out of bounds");
    }
    if (tileType == null) {
        throw new NullPointerException("Tile type cannot be null");
    }
    tiles[x][y] = tileType;
    initiated = true;
    return this;
}