private TileType getRandomLandTileType(int latitude) {
    if (landTileTypes == null) {
        landTileTypes = transform(spec.getTileTypeList(), t -> !t.isElevation() && !t.isWater());
    }
    return getRandomTileType(landTileTypes, latitude);
}