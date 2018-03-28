public boolean isTileTypeAllowed(TileType tileType) {
    return all(getScopes(), s -> s.appliesTo(tileType));
}