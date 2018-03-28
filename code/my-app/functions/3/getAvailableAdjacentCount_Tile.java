public int getAvailableAdjacentCount() {
    return count(getSurroundingTiles(1, 1), matchKey(isLand(), Tile::isLand));
}