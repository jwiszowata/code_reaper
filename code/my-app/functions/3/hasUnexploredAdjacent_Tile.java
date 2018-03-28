public boolean hasUnexploredAdjacent() {
    return !all(getSurroundingTiles(1, 1), Tile::isExplored);
}