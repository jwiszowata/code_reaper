public boolean isLandLocked() {
    return (!isLand()) ? false : all(getSurroundingTiles(1, 1), Tile::isLand);
}